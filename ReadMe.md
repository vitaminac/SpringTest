# Guide
* ## Our Goal
    0. [Bilibili Like Danmaku Video Website](https://github.com/WhiteBlue/bilibili-html5)

* ## Incidence
    * 

* ## What we'll do next
    * Danmuku table, model, controller

* ## TODO List
    0. Create request from map angular, put it in utils service
    0. fix cover size
    0. delete file when delete video record
    
* ## Features Request Sorted By Priority 
    0. Upload danmaku
        0. Hook send & receive danmaku api in dPlayer
    0. Refactor form
        0. Refactor Login Form using Ant Design demo
            0. [Ant Design Form](https://ng.ant.design/components/form/en)
        0. [Boostrap Form](https://getbootstrap.com/docs/4.0/components/forms/)
    1. [Watching Video](https://www.bilibili.com/blackboard/html5player.html)
    2. [Library Component](https://www.bilibili.com/anime/index)
        * Filter with query params
        * resources/:type or pass through attribute @Input
            * Animes, TV Series, Films, Mangas, Books
            *  {path: 'animes', component: LibraryComponent, data: { title: 'anime List' }}
                * Custom Title For Each Type Of Resource
        * An independent module
            * Export only a single component
        * Backend API /api/video/type
        * [Resource Component]
    0. [Cover Flow](http://jabbany.github.io/ABPlayerHTML5/build/demos/coverflow.html) jquery plugin
    0. [Live Comment (Danmaku) Engine](https://github.com/jabbany/CommentCoreLibrary)
    4. Upload subtitle
    6. Header Image
    0. Angular Modal
    0. OAuth
    7. [Live Video Streaming](https://www.bilibili.com/blackboard/live/live-activity-h5-player.html?cid=46936&type=room)
    8. Lazy Load Image
    10. RememberMe
    11. Encrypt Password
    0. Allow Request With Wrong Credentials to Non-Authentication-Require-Endpoint
    0. Require XMLHttpRequest Header For Any Request
    0. [NoSQL for file storage or image](https://docs.mongodb.com/manual/core/gridfs/)
    0. Create a bean that return strings for use of other service, it take care of internalization for web service and any other
    0. a separate [Worker](https://developer.mozilla.org/en-US/docs/Web/API/Web_Workers_API/Using_web_workers) for danmaku
    0. Video tap go forward o back like YouTube in mobile
    0. CRUD that create CRUD
    0. Replace path const in web app with hateo
    0. Identify where and which design pattern we have used
    0. Content Security Policy (CSP)  - script and resource
    0. Lazy Loading Scripts and Styles in Angular
    0. allow SWF(game) and FLV
    
* ## Future Components
    * Spring HATEOAS
    * Karma
    * Logger
    * Testing
        * [Selenium](https://www.seleniumhq.org/)
        * Spring Testing
    * UI
        * [Official Angular Component UI](https://material.angular.io/)
        * [Semantic UI](https://semantic-ui.com/)
        * CSS
            [Materialize](https://materializecss.com/)
    * [WebTorrent](https://github.com/webtorrent/webtorrent)
    * [Socket.IO](https://socket.io/)
    * [stackedit](https://github.com/benweet/stackedit)
    * ElasticSearch
    * Spring Eureka Discovery
    * Angular i18n
    * Semantic Web - Seo
    * Deploy Using [Docker](https://www.docker.com/)
        * Redis - Session
        * [Tomcat](http://tomcat.apache.org/) (War Deployment)
        * Nginx - Serving Static Content Under Http Context
            * setting up /api prefix for service
        * Node.js As Frontend
        * DBMS
            * Create a database and create a role at init
            * Create a user that only has insert, update and select privilege
            * Execute schema.sql and data.sql and init.db
    * Google Analytics
    * [rawgit](https://rawgit.com/)
    * [Modernizr](https://modernizr.com/)
    * [Crypto-JS](https://github.com/brix/crypto-js)
    
* ## Remember
    * [Make Features Service Globally Available](https://angular-2-training-book.rangle.io/handout/modules/feature-modules.html)
    * Create GIT branch for new feature and pull request for merge
    * Write TODO
    * Javadoc in and only in abstract method
    * @JsonIgnore in Relation column
    * Comment Each Modification About The Exception And Solution Reference
    * Naming Convention
        * The **$** is a convention that indicates heroes$ is an Observable
        * *Manager, *Service, *Dao, *Controller, *Repository
    * Where to place JavaScript? Just before you need it and no sooner
    * When subscribing to an observable in a component, you almost always arrange to unsubscribe when the component is destroyed
    * Use switch map for network operation, it will cancels previous in-flight requests
    * Handle exception in proper layer
    * The component should not have too much awareness of the template details
    * Add prefix /api/ in security AntMatcher
    * document each web service api
    
* ## Dev Documentations Sorted By Reference Times
    * Completed Tutorial
        * [Uploading Files With Spring](https://spring.io/guides/gs/uploading-files/)
    * [Spring REST](https://spring.io/guides/tutorials/rest/)
    * [Learn Rxjs](https://www.learnrxjs.io/)
    * [Hibernate ORM](http://docs.jboss.org/hibernate/stable/orm/userguide/html_single/Hibernate_User_Guide.html)
    * [Hibernate](http://docs.jboss.org/hibernate/stable/)
    * [Spring Framework](https://docs.spring.io/spring/docs/current/spring-framework-reference/)
    * [Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
    * [Spring Application Properties](https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html/)
    * [Angular Resources](https://angular.io/resources)
    * [Configure Angular HMR](https://github.com/angular/angular-cli/wiki/stories-configure-hmr)
    
* ## Technology Stack AND Thanks The Following Open Source Projects
    + PostgresSQL
    + Spring
    + Hibernate
    + [Angular 6](https://angular.io/)
    + [Bootstrap 4](https://getbootstrap.com/docs/)
    + AOP
        * [Lombok](https://projectlombok.org/)
    + UI
        * [Bootstrap Angular](https://ng-bootstrap.github.io/)
        * [Ant Design](https://github.com/NG-ZORRO/ng-zorro-antd)
        * [DPlayer](https://github.com/MoePlayer/DPlayer), [angular-dplayer](https://github.com/MoePlayer/angular-moeplayer)
        

* ## Architecture
    * Server-side
        * Micro-Service
        * REST API
        * Controller
        * Repository
        * DTO Model
        * ORM Mapping
        * Underlying Persistence Layer
    * Client-side
        * View
        * Controller
        * Service
        * Routing base modular, multi-view design

Dev Ops
    * Docker
    * Test Driven Development
        
* ## Security
    * Https
    * Http Basic Authentication
    * Cross Origin Domain
    * XSRF Cross-site request forgery
    * Session Fixation
    * SQL Injection

* ## Deployment
    * [Media & Video Transcoding In Cloud](https://aws.amazon.com/elastictranscoder/?nc1=h_ls)

* ## Useful Tips
    * Angular
        * Router
            * Router event subscript
            * Router's CanDeactivate guard
                * The guard gives you a chance to clean-up or ask the user's permission before navigating away from the current view
            * RouterLink Query Params
                * Query string parameters are provided through the [queryParams] binding which takes an object (e.g. { name: 'value' })
                * Filter Page
            * RouterLinkActive
                * The directive for adding/removing classes from an HTML element when an associated routerLink contained on or inside the element becomes active/inactive.
            * Router navigate pass map result in 
        * @Output
        * Unclassified
            * [To force change detection](https://stackoverflow.com/a/35106069/9980245)
                * [ApplicationRef.tick()](https://angular.io/api/core/ApplicationRef#tick)
                * [NgZone.run(callback)](https://angular.io/api/core/NgZone#run)
                * [ChangeDetectorRef.detectChanges()](https://angular.io/api/core/ChangeDetectorRef#detectChanges)
            * How to solve circular dependency
                * constructor(@Inject(forwardRef(() => CredentialService)) private service: Service, ...)
            * Enable class
                * [class.selected]="hero.id === selectedId"
                * [search pipe](https://angular.io/tutorial/toh-pt6#the-searchterms-rxjs-subject)
                    * debounceTime(300), // wait 300ms after each keystroke before considering the term
                    * distinctUntilChanged(), // ignore new term if same as previous term
                    * switchMap((term: string) => this.heroService.searchHeroes(term)), // switch to new search observable each time the term changes
            * ng generate class Hero
        * Form
            * The control has been visited.     ng-touched	ng-untouched
            * The control's value has changed.  ng-dirty	ng-pristine
            * The control's value is valid.	    ng-valid	ng-invalid
            * Key event filtering key.enter link
    * Spring
        * @Slf4j
            * Lombok annotation to autocreate an Slf4j-based LoggerFactory as log
        * @RequestParam, Query Param
    * CSS
        * position: sticky 
    * Hibernate
        * Inheritance table in Postgres and Jpa @MappedSuperClass
    * JSON
        * @JsonCreator - signal on how Jackson can create an instance of this POJO
        * @JsonProperty - clearly marks what field Jackson should put this constructor argument into
    * HTML
        * onblur
            * user leaves an input field

* ## Frequent errors
    * 401 Http Status error
        * The login credential is wrong
    * Observable only when get returned when it is actually be subscribed
    * 
        
* ## Glossary
    * Unknown
        * JSON Web Token (JWT)
        * Domain driven design
        * Jaxb Json
        * DDD: Repository Implementation Patterns
        * Query Object
    * Programming paradigm
        * Object-oriented programming
        * Declarative programming with Spring
        * AOP - Aspect-oriented programming
            * Functional programming 
            
    * Design Pattern
        * DAO - Data Access Object
        * Delegation pattern
        * CDI - Context And Dependencies Injection
        * MVC - Model-View-Controller
        * Chain-of-responsibility
        * Singleton
        
    * Anemic Domain Model
        * DTO - It Encapsulate The Communication Between Two Process, e.g. As Parameter Or Return Value
        * CRUD - Create, Read, Update And Delete
        * POJO - Plain Old Java Object
