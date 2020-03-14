Программа Пиццерия

Для базы данных была использована postgreSql
Ее подключение просходит в классе Database,
а параметры к подключению находятся в application.properties

Была использована структура entity->dao->service->controller
где:
entity-Pizza
dao-PizzaDao
service-PizzaService
controller-Controller

в классе Pizza просто макет для ее созданий
в классе PizzaDao используются sql для БД и ивенты
так же в папке с PizzaDao используется PizzaMapper, который нужен для создания объектов пиццы
из данных взятых с таблицы в БД
в PizzaDao так же используются ивенты (ApplicationEventPublisher eventPublisher), которые написаны
в классах, которые находятся в папке Event (и их handlers)
Запуск ивента происходит при создании, обновлении данных и удалении пиццы

В PizzaService после получения данных с PizzaDao класс сохраняет их в определенный List для отображения их
В Controller написан menu, которая отображет меню в консоли и использует функции PizzaService

Почти во всех классах были использованы таки аннотации, как: @Component, @Autowired, @Value
Аннотация @PostConstruct была использована в классе Database, чтоб после функция init()
была вызвана создания ее бина

В Main происходит создание context и с помощью него мы вызывваем у controller функцию menu()

"Бэкап базы данных находится в папке проекта и называется backupPizza"
"для ее создания используйте pgAdmin4"