package bookmarks;

import org.springframework.hateoas.ResourceSupport;
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
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
class BookmarkRestController {

    private final AccountRepository accountRepository;
    private final BookmarkRepository bookmarkRepository;

    BookmarkRestController(BookmarkRepository bookmarkRepository, AccountRepository accountRepository) {
        this.bookmarkRepository = bookmarkRepository;
        this.accountRepository = accountRepository;
    }

    @PostMapping("/{userId}/bookmarks")
    ResponseEntity<?> add(@PathVariable String userId, @RequestBody Bookmark input) {

        this.validateUser(userId);

        return accountRepository.findByUsername(userId)
                                .map(account -> ResponseEntity.created(URI.create(new BookmarkResource(bookmarkRepository
                                        .save(Bookmark.from(account, input))).getLink("self")
                                                                             .getHref()))
                                                              .build())
                                .orElse(ResponseEntity.noContent().build());
    }

    /**
     * Find a single bookmark and transform it into a {@link BookmarkResource}.
     *
     * @param userId
     * @param bookmarkId
     * @return
     */
    @RequestMapping(path = "/{userId}/bookmarks/{bookmarkId}", method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE, "application/hal+json"
    })
    BookmarkResource readBookmark(@PathVariable String userId, @PathVariable Long bookmarkId) {
        this.validateUser(userId);

        return this.bookmarkRepository.findById(bookmarkId)
                                      .map(BookmarkResource::new)
                                      .orElseThrow(() -> new BookmarkNotFoundException(bookmarkId));
    }

    @RequestMapping(path = "/{userId}/bookmarks", method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE, "application/hal+json"
    })
    Resources<BookmarkResource> readBookmarks(@PathVariable String userId) {

        this.validateUser(userId);

        return new Resources<>(bookmarkRepository.findByAccountUsername(userId)
                                                 .stream()
                                                 .map(BookmarkResource::new)
                                                 .collect(Collectors.toList()));
    }

    @RequestMapping(method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE, "application/hal+json"
    })
    ResourceSupport root() {
        ResourceSupport root = new ResourceSupport();

        root.add(accountRepository.findAll()
                                  .stream()
                                  .map(account -> linkTo(methodOn(BookmarkRestController.class)
                                          .readBookmarks(account.getUsername()))
                                          .withRel(account.getUsername()))
                                  .collect(Collectors.toList()));

        return root;
    }

    /**
     * Verify the {@literal userId} exists.
     *
     * @param userId
     */
    private void validateUser(String userId) {
        this.accountRepository.findByUsername(userId)
                              .orElseThrow(() -> new UserNotFoundException(userId));
    }
}