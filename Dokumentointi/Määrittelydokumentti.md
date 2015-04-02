# Määrittelydokumentti

Työn tarkoituksena tutkia algoritmejä, joiden avulla etsiä ja vertailla sanojen esiintymistä kielellisissä konteksteissa tai tuottaa tekstiä näistä konteksteista hankittujen tietojen pohjalta.

Työssä on otettu jonkun verran mallia Natural Language Tool Kit -paketista, esimerkiksi sen similar()-metodista. Metodi etsii annetuille sanoille annetusta tekstistä sitä, millaisissa konteksteissa (eli millaisten sanojen ympäröiminä) ne esiintyvät, ja vertailee sitä, mitkä sanat esiintyvät usein samanlaisissa konteksteissa. NLTK:n metodista poiketen tässä työssä halutaan kuitenkin haulta monipuolisempia  ominaisuuksia: voitaisiin esimerkiksi vertailla erilaajuisia esiintymisympäristöjä tai syntaktisesti samankaltaisia eri sanoja sisältäviä ympäristöjä.

Aluksi lähdetään siis työstämään metodeja, joiden avulla saadaan ainoastaan luetteloita samanlaisissa konteksteissa esiintyvistä sanoista ja näille yhteisistä konteksteista. Myöhemmin työtä voidaan laajentaa eri sovellusaloille sen mukaisesti, miten se näyttää etenevän. Sovellusaloja voisivat olla esimerkiksi tekstin tyylin tunnistus, jonkin sanan tai ilmaisun sävyn selvittäminen ja automaattinen tekstinsyöttö. Kiinnostava ongelma voisi olla esimerkiksi huonosti nimettyjen muuttujien tunnistaminen opiskelijoiden kirjoittamasta koodista. Silloin toteuttaa algoritmi, joka kävisi läpi opiskelijan kirjoittaman koodin ja vertailisi, onko muuttujat nimetty samassa kontekstissa samalla tavoin kuin jossakin hyvin kirjoitetussa mallikoodissa. Muita kiinnostavia ongelmia sen automaattinen vertailu, onko jokin sana esitetty negatiivisessa vai positiivisessa kontekstissa, ja automaattinen tietyn tyylisen tekstin generointi (erityisen jännittävää voisi olla selvittää, mitä vaadittaisiin siihen, että tietokone generoisi jonkin aineiston pohjalta syntaktisesti järkevää Java-koodia).

Yksi mahdollinen hyödyllinen tietorakenne työn toteuttamisen kannalta voisi olla trie-puurakenne, johon voitaisiin tallettaa lauseiden alkuosia. Trie-rakenteiden aikavaatimus haulle on O(s), missä s on talletetun merkkijohon pituus. Metodien toiminnan tehokkuutta voidaan myös arvioida mittaamalla niiden nopeutta python-koodina toteutetun NLTK:n samankaltaisten metodien kanssa, kunhan algoritmit ovat valmiita. 

http://en.wikipedia.org/wiki/Trie

http://www.nltk.org/book/ch01.html#searching-text

http://www.nltk.org/_modules/nltk/text.html#Text.similar
