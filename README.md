# collection-manager-backend
collection manager backend API

Link do repozytorium frontendu:
https://github.com/J-Fi/collection-manager-frontend

1) projekt jest przygotowany do uruchomienia na lokalnym serwerze localhost:8080.
2) aplikacja umożliwia stworzenie bazy danych swojej domowej biblioteczki oraz filmów
3) moduł filmowy nie jest jeszcze widoczny we frontendzie, ale w backendzie jest w znacznej mierze wdrożony i działa
4) dzięki połączeniu z zewnętrznym API Isbndb można wyszukiwać książki wpisując jedynie nr isbn - reszta danych zostaje dostarczona przez aplikację.
5) moduł filmowy korzysta z API Omdb - umożliwia wyszukiwanie filmów po tytule w bazie Omdb
6) aplikacja umożliwa także wprowadzanie danych książki lub filmu ręcznie.
7) frontend uruchamiamy wpisując adres: localhost:8081/login
8) dalsze kroki należy wykonywać zgodnie z instrukcjami, które wyświetlą się na stronie o któej mowa w pkt. 7
9) aplikacja ma wdrożoną funkcjonalność @Schedulera, któy informuje administratora o stopniu wykorzystania dziennego limitu zapytań do bazy aplikacji Isbndb
