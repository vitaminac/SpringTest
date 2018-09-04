# Guide

* ## TODO List
    1. Thanks list in ReadMe.md
    
* ## Request Features, Sorted By Priority 
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
        * [Resource Component]() represent a single resource, independent of its type
            * Filed
                * Description
                * Cover
                * Uploader
                * URI
    3. Upload video
    4. Upload subtitle
    5. Upload danmaku
    6. Header Image
    7. Live Video Streaming (直播)
    8. Lazy Load Image
    9. Add BL Layer And Dao Layer
    10. RememberMe
    11. Encrypt Password
    
* ## Future Components
    * [Dplayer](https://github.com/MoePlayer/DPlayer), [Angular component](https://github.com/Guanyunhan/angular-dplayer)
    * Spring HATEOAS
    * Spring Testing
    * Karma
    * [WebTorrent](https://github.com/webtorrent/webtorrent)
    * Redis - Session
    * Nginx - Serving Static Content Under Http Context
    * [Socket.IO](https://socket.io/)
    * Tomcat (War Deployment)
    * Angular i18n
    * Semantic Web - Seo
    
* ## Remember List
    * @JsonIgnore in Relation column
    * Comment Each Modification About The Exception And Solution Reference
    
* ## Dev Documentations
    * [Configure Angular HMR](https://github.com/angular/angular-cli/wiki/stories-configure-hmr)
    
* ## Technology Stack
    + PostgresSQL
    + Spring
    + Hibernate
    + [Angular 6](https://angular.io/)
    + [Bootstrap 4](https://getbootstrap.com/docs/)

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
    * Router event subscript
    * 