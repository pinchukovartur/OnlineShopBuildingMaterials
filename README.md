Online Shop

Для запуска проекта потребуется:

    -JDK 1.8
    -TomCat 8.5.8
    -IntelliJ IDEA 2016.3
    
Для того чтобы собрать проект требуется:

    1. В ProjectStructure/Modules узакать xml файлы для Hibernate, 
      SpringMVC.
    2. Создать ProjectStructure/Acrtifacts приложения
      и добавить в папку WEB-INF/lib все библиотеки 
      SpringMVC Hibernate(лучше весь maven, вернее будет).
    3. В настройках TomCat в вкладке deployment добавить
      наш Artifacts