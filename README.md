# DinomonTCG

A [libGDX](https://libgdx.com/) project generated with [gdx-liftoff](https://github.com/libgdx/gdx-liftoff).

This project was generated with a template including simple application launchers and an `ApplicationAdapter` extension that draws libGDX logo.

## Platforms

- `core`: Main module with the application logic shared by all platforms.
- `lwjgl3`: Primary desktop platform using LWJGL3; was called 'desktop' in older docs.
- `html`: Web platform using GWT and WebGL. Supports only Java projects.

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
- `html:dist`: compiles GWT sources. The compiled application can be found at `html/build/dist`: you can use any HTTP server to deploy it.
- `html:superDev`: compiles GWT sources and runs the application in SuperDev mode. It will be available at [localhost:8080/html](http://localhost:8080/html). Use only during development.
- `idea`: generates IntelliJ project data.
- `lwjgl3:jar`: builds application's runnable jar, which can be found at `lwjgl3/build/libs`.
- `lwjgl3:run`: starts the application.
- `test`: runs unit tests (if any).

Note that most tasks that are not specific to a single project can be run with `name:` prefix, where the `name` should be replaced with the ID of a specific project.
For example, `core:clean` removes `build` folder only from the `core` project.

#Dinomon
O jogo de cartas do Geoparque Quarta Colônia

Autoria: Antônio Sérgio Tolio e Gustavo Pott, alunos de Sistemas de Informação, UFSM

Dinomon é um jogo digital de cartas de dinossauros inspirado no Geoparque Quarta Colônia onde é possível duelar com diferentes cartas e elementos. O jogo conta com 30 cartas de dinossauros, distribuídas em três elementos: terrestre, aquático e voador, representando diferentes tipos de dinossauros. Inspirado no modo de jogo Desafio Ninja do famoso Club Penguin, é preciso vencer três duelos com um mesmo elemento e acertar uma pergunta sobre o Geoparque para ser vitorioso. Cada elemento é forte e fraco contra outros elementos. O elemento terrestre é forte contra aquático e fraco contra voador, o elemento aquático é forte contra voador e fraco contra terrestre e o elemento voador é forte contra terrestre e fraco contra aquático. Se duas cartas de mesmo elemento se enfrentam, vence o de maior valor, uma vez que cada carta possui um valor de 1 a 10.

O jogo foi desenvolvido em Java com a utilização da bilioteca gráfica libgdx para a disciplina de Paradigmas de Programação do segundo semestre de 2024. Os criadores dividiram as tarefas entre si. Enquanto Antônio ficou responsável pela lógica do jogo e implementação da mesma, Gustavo foi responsável pela criação das artes, implementação das telas e botões e quiz. A ideia do jogo é crédito de Gustavo, que pensou em recriar o mini game do Club Penguin em sua versão jurássica. Ao contar isto para Antônio, ele ficou interessado e os dois decidiram juntar forças. Todas as imagens presentes no jogo foram geradas com o auxílio da inteligência artifical do Windows, o Copilot. O prompt utilizado para a criação das cartas foi: quero a imagem de um dinossauro astronauta (insira aqui a descrição dele) no formato 750x450. 


fonte das infos do quiz:
https://dinossaurosdobrasil.wixsite.com/dinossauros-e-afins/macrocollum
https://jornal.usp.br/ciencias/reconstituicao-de-cranio-revela-que-dinossauro-de-233-milhoes-de-anos-era-cacador-com-visao-agucada/
https://jornal.usp.br/ciencias/ciencias-biologicas/mandibula-voraz-conheca-o-dinossauro-predador-mais-antigo-do-brasil/
https://www.geoparquequartacolonia.com.br/home
https://www.ufsm.br/midias/arco/tataravo-de-gigantes
