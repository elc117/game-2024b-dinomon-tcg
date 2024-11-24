# DinomonTCG

A [libGDX](https://libgdx.com/) project generated with [gdx-liftoff](https://github.com/libgdx/gdx-liftoff).

This project was generated with a template including simple application launchers and an `ApplicationAdapter` extension that draws libGDX logo.

## Platforms

- `core`: Main module with the application logic shared by all platforms.
- `lwjgl3`: Primary desktop platform using LWJGL3; was called 'desktop' in older docs.
- `teavm`: Experimental web platform using TeaVM and WebGL.

## Gradle

This project uses [Gradle](https://gradle.org/) to manage dependencies.
The Gradle wrapper was included, so you can run Gradle tasks using `gradlew.bat` or `./gradlew` commands.
Useful Gradle tasks and flags:

- `--continue`: when using this flag, errors will not stop the tasks from running.
- `--daemon`: thanks to this flag, Gradle daemon will be used to run chosen tasks.
- `--offline`: when using this flag, cached dependency archives will be used.
- `--refresh-dependencies`: this flag forces validation of all dependencies. Useful for snapshot versions.
- `build`: builds sources and archives of every project.
- `cleanEclipse`: removes Eclipse project data.
- `cleanIdea`: removes IntelliJ project data.
- `clean`: removes `build` folders, which store compiled classes and built archives.
- `eclipse`: generates Eclipse project data.
- `idea`: generates IntelliJ project data.
- `lwjgl3:jar`: builds application's runnable jar, which can be found at `lwjgl3/build/libs`.
- `lwjgl3:run`: starts the application.
- `teavm:build`: builds the JavaScript application into the build/dist/webapp folder.
- `teavm:run`: serves the JavaScript application at http://localhost:8080 via a local Jetty server.
- `test`: runs unit tests (if any).

Note that most tasks that are not specific to a single project can be run with `name:` prefix, where the `name` should be replaced with the ID of a specific project.
For example, `core:clean` removes `build` folder only from the `core` project.

Dinomon TCG

TCG:
Design cartas - Gustavo

O jogo vai ser um jokenpo de dinossauros que segue as regras de vitória abaixo, sendo necessário que cada jogador vença 3 vezes sendo uma de cada carta, uma de terra, uma de voador ou de aquático. Caso ele ganhe 3 terras ele ainda precisa ganhar um aquático e um voador.

No início de cada rodada, você inicia com 3 cartas na mão. Sendo assim, você joga uma carta por rodada, cada carta possui um tipo ( Voador, Terrestre e aquático) e um valor. A rodada acaba quando os dois jogarem a carta e um sair vencedor: Jogado as duas cartas por cada player, o com o tipo certo ganhará igual jokenpo, porém se forem do mesmo tipo a com o valor mais alto irá ganhar e se as duas empataram será necessário responder um quiz e quem responder mais rápido e acertar vai ganhar a rodada.
Ao final da rodada e no início da rodada seguinte, cada jogador irá ganhar mais uma carta completando novamente 3 cartas na mão.

Vão haver classes no jogo onde você pode selecionar, elas
Classes
Sortudo:
Nao tem poder mas aumenta a chance de ter cartas melhores

Predador:
Pode roubar uma carta do inimigo.

Herbívoro:
Ganha um escudo que impede uma derrota das cartas.

Velociraptor:
Retira uma carta aleatória dos pontos do inimigo.

Terra
Terra ganha Aquático,
Perde para voador.
Empata com terra


Aquático
Aquático ganha Voador
Perde para Terra
Empata com
Aquático

Voador
Ganha de terra
Perde pra água
Empata com voador

Tela inicial (arte com botões)
Jogar ( Vai listar as salas que dá para entrar)
Criar sala (Gera um código)
Sair da sala
Pronto
Voltar
Entrar numa sala
Ajuda (Informação sobre as regras)
Voltar
Sair

