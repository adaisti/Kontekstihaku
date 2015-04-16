# Viikkoraportti 4

Trie-rakenteessa sekä tallentaminen että hakeminen on nopeaa ja kätevää, joten siksi rakenne soveltuu erityisen hyvin automaattiseen tekstin generointiin. Sitä käytetäänkin usein esimerkiksi kännyköiden automaattisessa tekstinsyötössä, kun käyttäjän näpyttelemien kirjainten perusteella voidaan arvata sanan loppupuoli. Lähdinkin siis viikolla 4 kehittämään tämänkaltaisia toimintoja.

Ensimmäinen toteuttamani tekstin generoija on metodi, joka yksinkertaisesti generoi triestä löytyvän sanan sattumanvaraisesti. Metodi aloittaa puun läpikäymisen tyhjästä juuresta ja etenee siitä sattumanvaraisesti johonkin solmuun. Solmusta edetään jälleen sattumanvaraisesti seuraavaan, ja niin edelleen, kunnes päädytään solmuun, jolla ei ole enää lapsia. Tällainen solmu on poikkeuksetta lopetusmerkki $, eikä sitä lisätä generoituun sanaan. Ensimmäisen $-merkin vastaantullessa ei kuitenkaan haluta lopettaa, koska muuten metodi generoisi vain varsin lyhyitä sanoja, joten siksi tarkistus tehdään vasta silloin, kun solmu on jo arvottu.

Täysin sattumanvaraisen sanan luovasta metodista on helppo siirtyä metodiin, joka luo täysin sattumanvaraisesti loppuvan sanan tietyn annetun alun perusteella. Näin voidaan esimerkiksi arvata, miten "huo"-alkuinen sana voisi jatkua. Aluksi tarkistetaan, löytyykö sanan alkua ollenkaan trie-rakenteesta.
