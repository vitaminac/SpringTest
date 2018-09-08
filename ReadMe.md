# Guide
* ## Our Goal
    0. [Bilibili Like Danmaku Video Website](https://github.com/WhiteBlue/bilibili-html5)

* ## TODO List
    0. Reload Component When Logout
    
* ## Features Request Sorted By Priority 
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
    3. Upload video
    4. Upload subtitle
    5. Upload danmaku
    6. Header Image
    7. Live Video Streaming (直播)
    8. Lazy Load Image
    9. Add BL Layer And Dao Layer
    10. RememberMe
    11. Encrypt Password
    0. Allow Request With Wrong Credentials to Non-Authentication-Require-Endpoint
    0. Require XMLHttpRequest Header For Any Request
    0. [NoSQL for file storage](https://docs.mongodb.com/manual/core/gridfs/)
    
* ## Future Components
    * Spring HATEOAS
    * Spring Testing
    * Karma
    * Logger
    * [WebTorrent](https://github.com/webtorrent/webtorrent)
    * [Socket.IO](https://socket.io/)
    * [stackedit](https://github.com/benweet/stackedit)
    * Angular i18n
    * Semantic Web - Seo
    * Deploy Using [Docker](https://www.docker.com/)
        * Redis - Session
        * [Tomcat](http://tomcat.apache.org/) (War Deployment)
        * Nginx - Serving Static Content Under Http Context
        * Node.js As Frontend
        * DBMS
            * Create a database and create a role at init
            * Create a user that only has insert, update and select privilege
            * Execute schema.sql and data.sql and init.db
    * Google Analytics
    
* ## Remember
    * [Make Features Service Globally Available](https://angular-2-training-book.rangle.io/handout/modules/feature-modules.html)
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
    
* ## Dev Documentations Sorted By Reference Times
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
        * [DPlayer](https://github.com/MoePlayer/DPlayer), [angular-dplayer](https://github.com/MoePlayer/angular-moeplayer)
        

* ## Architecture
    * Server-side
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
        
* ## Security
    * Https
    * Http Basic Authentication
    * Cross Origin Domain
    * XSRF Cross-site request forgery
    * Session Fixation
    * SQL Injection

* ## Useful Tips
    * Spring
        * @RequestParam, Query Param
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
    * Spring
        * @Slf4j
            * Lombok annotation to autocreate an Slf4j-based LoggerFactory as log
        * @Bean CommandLineRunner
            * Spring Boot will run ALL CommandLineRunner beans once the application context is loaded.
    * CSS
        * position: sticky 
    * Hibernate
        * Inheritance table in Postgres and Jpa @MappedSuperClass
        
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
        
    * Anemic Domain Model
        * DTO - It Encapsulate The Communication Between Two Process, e.g. As Parameter Or Return Value
        * CRUD - Create, Read, Update And Delete
        * POJO - Plain Old Java Object
            