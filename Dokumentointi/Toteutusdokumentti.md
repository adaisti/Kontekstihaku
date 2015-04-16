# Toteutusdokumentti

Ehkä vaikeinta tämänkaltaisessa työssä on päättää, mihin osa-alueisiin työ keskittyy ja millä tavoilla osa-alueita lähtisi lukuisista kiinnostavista vaihtoehdoista toteuttamaan. Vaikka aluksi tarkoitus oli keskittyä sanojen hakemiseen erilaisista konteksteista ja näiden kontekstien vertailuun, päädyin pidemmän päälle käyttämään enemmän aikaa sanojen ja tekstin automaattiseen generointiin. Tärkeimpänä tietorakenteena hakemisessa ja generoinnissa toimii trie-rakenne, jossa merkkijonon lisääminen ja hakeminen on O(s)-aikaista, missä s on merkkijonon pituus.

Verrattuna esimerkiksi hash-rakenteisiin, joilla olisi ollut myös mahdollista toteuttaa vastaava merkkijonojen talletusjärjestelmä, trie on monilta osin edullisempi. Trie-rakenteen pahimman tapauksen hakuaika on nopeampi, ja siinä missä hash-rakenteessa ylivuotoketjuista voi muodostua ongelma, ei niitä trie-rakenteessa esiinny. Lisäksi trie-rakenteen vakiokertoimet ovat huomattavasti pienemmät kuin hash-rakenteen, sillä hajautusfunktion luomista ei tarvita. Etuna on myös trien O(n)-tilavaativuus, missä n on erilaisten merkkien määrä.

Trie-rakenteiden ansiosta ohjelmassa toteutettu sanojen tallettaminen ja generoiminen on siis varsin tehokasta eikä vie kovinkaan paljon muistia. Muita toiminnallisuuksia on toteutettu paljon geneerisemmän lista-rakenteen avulla, joka on rakennettu puurakenteen sijaan taulukoita hyödyntäen. Sen aika- ja tilavaatimukset ovat paljon suuremmat. Voisikin olla kiinnostavaa lähteä toteuttamaan esimerkiksi kontekstien vertailua muiden tietorakenteiden avulla, kuten triehen perustuvan suffiksipuun tai jonkinlaisen suffiksitaulun avulla.

Kontekstien hakeminen olisi kiinnostavaa yhdistää myös morfologisen jäsentämisen toimintaan. Ilman morfologista jäsennystä esimerkiksi lauseen "omenat tuoksuvat hyvältä" verbi "tuoksuvat" voi esiintyä samassa kontekstissa kuin esimerkiksi "maistuvat", mutta mikäli "maistuvat" esiintyisiin vain kontekstissa "omenat maistuvat hyvältäkin", ei yhteistä kontekstia löytyisi. Morfologinen jäsennin kuitenkin voisi tunnistaa sanojen "hyvältä" ja "hyvältäkin" olevan samaa kantaa, ja näin kontekstien hakeminen parantuisi.



Lähteet:

http://cses.fi/kkkk.pdf
http://en.wikipedia.org/wiki/Trie
http://en.wikipedia.org/wiki/Suffix_tree
http://en.wikipedia.org/wiki/Suffix_array
