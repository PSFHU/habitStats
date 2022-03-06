# Concept

Application is tracking a habits by measurement, that are numeric value based.\
This way there's an oportunity for making statistics on said habit progress.\
You also can set up goals on the progress.

<details>
    <summary>Magyar</summary>
    Az alkalmazáson követni lehet a szokásainkat statisztikailag.<br>
    A helyett, hogy egy nap csak bejelölnénk a szokásunk teljesítését, itt követni lehet a fejlődést is.
</details>

## Features

### Multiple users \ Felhasználó kezelés

Users can register, login and delete their account.

<details>
    <summary>Magyar</summary>
    Felhasználók tudnak regisztrálni, bejelentkezni törölni a fiókjukat.
</details>


### Creating habits with own categories and unit types \ Kategóriák és Saját mértékegységek

Sort your data in categories all your gym progresses goes in its own category.\
Select or create your own unit type to track progress like your max weight on the bench.

<details>
    <summary>Magyar</summary>
    Az haladás kategóriákba szervezhető, így például az edzés adatok külön gyűjthetők a többi közül.<br>
    Míg a saját mértékegységek készítése abban segít, hogy értelmezhetően lássd eredményeid.
</details>

### Setting goals \ Célok

Creating goals for your habits, can help a lot for finding motivation to do just a bit more.\
If its a bad habit you can set up goals for doing less with customizable logic.

<details>
    <summary>Magyar</summary>
    Ahhoz, hogy egy szokást vagy képességet elmélyits a célok elengedhetetlenek.<br>
    Vagy egy rossz berögződésről való leszokás is igényel egy célt.<br>
    Tehát létrhozhatunk célokat, akkár saját feltétel szerint is.
</details>

### External datasources \ Külső adatforrás

You can create a habbit and after that, there's option to add progress over the browser or\
by useing the service API.

<details>
    <summary>Magyar</summary>
    Adatokat hozzáadhat a web felületen vagy egy külső alkalmazással a szolgáltatás API-ján keresztül.
</details>

### Statistics \ Statisztikák

See your progress from months to weeks and get motivated or see where you should put in more work.

<details>
    <summary>Magyar</summary>
    Haladásunk követhetjük hónapokra és hetekre tekintve.
</details>

### Get notified on progress \ Értesítések a fejlődésről

Day by day or on week by week, you can setup to recive a summary on your current goals.

<details>
    <summary>Magyar</summary>
    Egy visszatekintőt kérhetünk napra vagy hétre, ami összefoglalja a teljesítményünk.
</details>

### You own your data \ Az adataid nálad vannak

The service can be self-hosted and easily deployed on your own computer.

<details>
    <summary>Magyar</summary>
    A szolgáltatás saját gépen is futtatható, könnyen telepíthető.
</details>

### Fast access over recent data \ Gyors adat elérés

Service uses a traditional POSTGRESQL database and an In-memory Redis database for quick access for recent data.

<details>
    <summary>Magyar</summary>
    A szolgáltatás egy tradicionális POSTGRESQL adatbázison hosszútávra és egy memória alapu Redis adatbázison fut a gyakori adatok gyors adatelérése érdekében.
</details>

### Scaleable \ Skálázható

If you decide to use the service with multiple users or use a lot of datasources.\
The backend can be split to multiple instances or tunned to usage.

<details>
    <summary>Magyar</summary>
    Ha a szolgáltatást sok felhasználó használja vagy nagy az adatforgalom a szerveren.<br>
    A háttér környezet szétosztható és a szolgáltatás részek külön szervereken is futtathatók.<br>
    Adatbázis tekintetben a gyorsító tárazás finomhangolható.
</details>
