# Viikkoraportti 2

Ensiksi rakentamani metodit käyttivät tietorakenteinaan listaa, ja päätin seuraavaksi tutkia tehokkaampia tietorakenteita luonnollisen kielen käsittelyyn. Toki työssä oli tarkoitus myös toteuttaa kaikki käytetyt tietorakenteet itse, ja siksi toteutinkin oman Lista-luokan, jolla korvata Javan ArrayList. Toteuttamani Lista-luokka sallii listan alkioiksi Stringejä, sillä kaikki projektissa listoiksi kerättävät objektit ovat nimenomaan String-muotoisia. Geneerisen tietorakenteen toteuttaminen osoittautui luultua hankalammaksi, joten ainakaan tässä vaiheessa projektissa luotu Lista-luokka ei salli listan alkioiden olevan muita kuin String-luokan ilmentymiä.

Listaa kiinnostavampi tietorakenne on kuitenkin trie. Päädyin valitsemaan trie-rakenteen, sillä halusin hyödyntää sitä yrittäessäni jäljentää Natural Language Toolkitin text.generate()-metodia. NLTK:n metodi tuottaa annetun tekstin tyylin mukaista satunnaissyötettä, joka on joka kerta erilaista, mutta joka perustuu tekstissä käytettyyn kieleen. Uusimmasta NLTK:n versiosta metodi on poistettu, eikä se välttämättä tuota kieliopillisesti korrektia tai semanttisesti järkevää sisältöä, mutta antaa kuitenkin kuvan aineistossa käytetystä kielestä. Itse en halunnut toteuttaa välttämättä ihan samanlaista metodia, mutta ehdottomasti tarkoituksenani on tutkia automaattisen tekstin generoinnin mahdollisuuksia ja etenkin sen asettamia rajoituksia.

Trie sopi tähän tietorakenteena hyvin, sillä trie-rakenteita käytetään esimerkiksi kännyköiden automaattisessa tekstinsyötössä niiden täydentäessä sanoja kokonaisiksi käyttäjän antamien merkkien perusteella. Aloitinkin tekemällä trie-rakenteen johon tallennetaan nimenomaan kaikki tekstissä esiintyvät sananmuodot merkki kerrallaan. Trie on eräänlainen puurakenne, jossa samanvartaloiset sanat tallentuvat samoihin oksiin, ja sanat jakavat oksat niiltä osin kuin niiden vartalot ovat samat. Jos siis trie-rakenteeseen lisätään esimerkiksi sanat "silmä", "silmukka" ja "koodi", tulee merkkijonosta "koodi" oma erillinen alkusolmusta lähtevä haaransa, kun taas "silmä" ja "silmukka" jakavat saman haaran merkkijonon "silm" osalta, ja puu haarautuu täydentämään jonot merkeillä "ä" ja "ukka". Alkusolmu ei siis ole sanassa mukana, sillä siitä lähtee erillisinä kaikkien eri kirjaimella alkavien sanojen kokonaisuuksien puut. (Vaihtoehtoinen tapa toteuttaa puu on tehdä siitä metsä, jossa jokainen eri kirjaimen juurekseen saava puu on erillinen puunsa.) Lisäksi jokainen puuhun lisättävän merkkijonon perään lisätään merkki lopetusmerkki sanan loppumisen merkiksi, jonka löytyminen voidaan tarkistaa puusta sanoja haettaessa. Näin ei synny tilannetta, jossa trie-rakenteeseen on lisätty esimerkiksi sana "puutarha" mutta ei sanaa "puu", mutta sana "puu" löytyisi sieltä haettaessa silti.

Trie-rakenteen apuluokaksi toteutin Solmu-luokan, joka tallentaa tiedot jokaisen solmun arvosta eli sen sisältämästä merkistä sekä solmun lapsista. Koska jokaiselle solmulle voi hakea sen lapset, sisältää jokainen trien solmu samalla tiedon kaikista sen lasten alipuista. Lisäksi solmulle annetaan tieto siitä, monenko sanan osana se on. Tätä tietoa käytetään hyväksi esimerkiksi poistettaessa sana triestä. Koko sanaa ei tietenkään voida välttämättä poistaa, sillä usein sana jakaa merkkejä muiden sanojen kanssa - juuri sehän on trie-rakenteen etu. On siis poistettava ainoastaan ne solmut, jotka sisältävät pelkästään poistettavan sanan loppuosan mutta ei minkään muun sanan merkkejä. Pienimmillään tällainen alipuu on pelkkä sanan lopetusmerkki.