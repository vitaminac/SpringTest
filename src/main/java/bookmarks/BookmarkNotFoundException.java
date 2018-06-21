package bookmarks;

class BookmarkNotFoundException extends RuntimeException {
    public BookmarkNotFoundException(Long bookmarkId) {
        super("could not find bookmark '" + bookmarkId + "'.");
    }
}
