package bookmarks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.security.Principal;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bookmarks")
class BookmarkRestController {

    private final AccountRepository accountRepository;
    private final BookmarkRepository bookmarkRepository;

    @Autowired
    BookmarkRestController(BookmarkRepository bookmarkRepository, AccountRepository accountRepository) {
        this.bookmarkRepository = bookmarkRepository;
        this.accountRepository = accountRepository;
    }

    @PostMapping
    ResponseEntity<?> add(Principal principal, @RequestBody Bookmark input) {

        this.validateUser(principal);

        return accountRepository.findByUsername(principal.getName())
                                .map(account -> ResponseEntity.created(URI.create(new BookmarkResource(bookmarkRepository
                                        .save(Bookmark.from(account, input))).getLink("self")
                                                                             .getHref())).build())
                                .orElse(ResponseEntity.noContent().build());
    }

    @RequestMapping(value = "/{bookmarkId}", method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE, "application/hal+json"
    })
    BookmarkResource readBookmark(Principal principal, @PathVariable Long bookmarkId) {
        this.validateUser(principal);

        return this.bookmarkRepository.findById(bookmarkId)
                                      .map(BookmarkResource::new)
                                      .orElseThrow(() -> new BookmarkNotFoundException(bookmarkId));
    }

    @RequestMapping(method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE, "application/hal+json"
    })
    Resources<BookmarkResource> readBookmarks(Principal principal) {

        this.validateUser(principal);

        return new Resources<>(bookmarkRepository.findByAccountUsername(principal.getName())
                                                 .stream()
                                                 .map(BookmarkResource::new)
                                                 .collect(Collectors.toList()));
    }

    private void validateUser(Principal principal) {
        String userId = principal.getName();
        this.accountRepository.findByUsername(userId)
                              .orElseThrow(() -> new UserNotFoundException(userId));
    }
}