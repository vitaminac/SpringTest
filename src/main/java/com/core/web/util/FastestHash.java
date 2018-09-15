package com.core.web.util;

import java.nio.ByteBuffer;

/**
 * https://cyan4973.github.io/xxHash/
 */
public class FastestHash {
    // Primes if treated as unsigned
    private static final long P1 = -7046029288634856825L;
    private static final long P2 = -4417276706812531889L;
    private static final long P3 = 1609587929392839161L;
    private static final long P4 = -8796714831421723037L;
    private static final long P5 = 2870177450012600261L;
    private static final long seed = 1234567890987654321L;


    private final ByteBuffer buf = ByteBuffer.allocate(32);
    private long v1 = seed + P1 + P2;
    private long v2 = seed + P2;
    private long v3 = seed;
    private long v4 = seed - P1;
    private long length = 0;

    public FastestHash() {
    }

    private void cycle() {
        if (buf.remaining() == 0) {
            this.buf.flip(); // ready for read

            v1 += fetch64() * P2;
            v1 = Long.rotateLeft(v1, 31);
            v1 *= P1;

            v2 += fetch64() * P2;
            v2 = Long.rotateLeft(v2, 31);
            v2 *= P1;

            v3 += fetch64() * P2;
            v3 = Long.rotateLeft(v3, 31);
            v3 *= P1;

            v4 += fetch64() * P2;
            v4 = Long.rotateLeft(v4, 31);
            v4 *= P1;

            this.buf.clear();
        }
    }

    public void digest(byte b) {
        this.cycle();
        buf.put(b);
        this.length++;
    }

    public long hash() {
        this.cycle();
        this.buf.flip();

        long hash = Long.rotateLeft(v1, 1)
                + Long.rotateLeft(v2, 7)
                + Long.rotateLeft(v3, 12)
                + Long.rotateLeft(v4, 18);

        v1 *= P2;
        v1 = Long.rotateLeft(v1, 31);
        v1 *= P1;
        hash ^= v1;
        hash = hash * P1 + P4;

        v2 *= P2;
        v2 = Long.rotateLeft(v2, 31);
        v2 *= P1;
        hash ^= v2;
        hash = hash * P1 + P4;

        v3 *= P2;
        v3 = Long.rotateLeft(v3, 31);
        v3 *= P1;
        hash ^= v3;
        hash = hash * P1 + P4;

        v4 *= P2;
        v4 = Long.rotateLeft(v4, 31);
        v4 *= P1;
        hash ^= v4;
        hash = hash * P1 + P4;

        hash += length;

        while (this.buf.remaining() >= 8) {
            long k1 = fetch64();
            k1 *= P2;
            k1 = Long.rotateLeft(k1, 31);
            k1 *= P1;
            hash ^= k1;
            hash = Long.rotateLeft(hash, 27) * P1 + P4;
        }

        if (this.buf.remaining() >= 4) {
            hash ^= fetch32() * P1;
            hash = Long.rotateLeft(hash, 23) * P2 + P3;
        }

        while (this.buf.remaining() != 0) {
            hash ^= fetch8() * P5;
            hash = Long.rotateLeft(hash, 11) * P1;
        }

        return this.finalize(hash);
    }

    private long fetch64() {
        return this.buf.getLong();
    }

    private long fetch32() {
        return this.buf.getInt();
    }

    private int fetch8() {
        return this.buf.get() & 0xFF;
    }

    private long finalize(long hash) {
        hash ^= hash >>> 33;
        hash *= P2;
        hash ^= hash >>> 29;
        hash *= P3;
        hash ^= hash >>> 32;
        return hash;
    }
}