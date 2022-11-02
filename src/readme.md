Program symulujący dworzec.
W klasie głównej definiujemy ile chcemy obsługiwać pociągów, ile peronów i pasazerów.
W klasie Dworzec mamy przypisane wartości liczbowe do poszczególnych stanów pociągów.
Metody w klasie Dworzec powiadamiają komunikatem o pomyślnym wykonaniu instrukcji wygłaszając komunikaty jak w prawdziwym pociągu.
W klasie Pociąg dochodzi kolejny stan INIT, który służy tylko do inicjalizacji pociągu aby nie robić spamu w konsoli.
Dodane są również stacje, aby dodać trochę realizmu :).
W poszczególnych stanach wykonywane są instrukcje, w niektórych z nich są wydarzenia zależne od liczb pseudolosowych,
ponieważ jak w prawdziwym świecie nie da się przewidzieć niektórych sytuacji.