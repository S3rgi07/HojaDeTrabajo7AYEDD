## Hoja de Trabajo 7
# Sergio López 25848

Palabras almacenadas en diccionario.txt:
about, appear, are, ask, asked, become, begin, believe, bring, build, buy, call, can, change, come, consider, continue, could, create, cut, decide, did, die, do, does, dog, expect, fall, feel, find, follow, get, give, go, goes, grow, had, happen, has, have, he, hear, help, her, his, homework, house, i, include, is, it, keep, kill, know, lead, learn, leave, let, live, look, lose, make, me, mean, meet, move, my, need, offer, open, our, pass, pay, play, pull, put, raise, reach, read, remain, remember, report, require, return, run, see, sell, send, serve, set, she, should, show, sit, speak, spend, stand, stay, stop, suggest, take, teach, tell, that, the, their, these, they, think, this, those, to, town, try, understand, use, wait, walk, want, was, watch, we, went, were, will, win, woman, work, would, write, yes, you, your

## En caso de que los JUnit no corran desde VSCode

# Para compilar:
javac -d bin -cp "lib\*;src" src\*.java (Windows)
javac -d bin -cp "lib/*:src" src/*.java (Mac/Linux)

# Para correr:
java -jar lib/junit-platform-console-standalone-1.13.0-M3.jar -cp bin --scan-classpath
