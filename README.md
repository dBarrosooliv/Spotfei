# SpotFei
Aluno: Daniel Barroso de Oliveira

R.A: 22.124.054-2

Repositório: https://github.com/dBarrosooliv/Spotfei/tree/main

Vídeo: https://youtu.be/Un4Ue4Oa1ME

# 1. Objetivo
O objetivo do projeto Spotifei é desenvolver um aplicativo desktop em Java Swing, utilizando JDBC PostgreSQL para persistência de dados e a arquitetura MVC, que permita aos usuários cadastrar-se, autenticar-se, buscar e listar informações sobre músicas por nome, artista ou gênero, curtir e descurtir músicas, gerenciar suas playlists e visualizar o histórico de interações, focando no compartilhamento de dados informativos sobre as músicas, sem a necessidade de reprodução.

# 2. O Banco de Dados

O modelo relacional do banco de dados para o projeto **Spotifei** é composto por diversas tabelas que gerenciam usuários, músicas, artistas, playlists e o histórico de interações.

---

## Tabelas

### `usuarios_cadastrados`
Armazena informações dos usuários.
- `userid` (PK): Identificador único do usuário
- `nome`: Nome do usuário
- `username`: Nome de usuário (login)
- `senha`: Senha do usuário

---

### `musicas_cadastradas`
Contém os detalhes das músicas.
- `musicaid` (PK): Identificador único da música
- `titulo_musica`: Título da música
- `album`: Álbum da música
- `artistaid` (FK): Chave estrangeira para `artistas_cadastrados`

---

### `artistas_cadastrados`
Registra os artistas.
- `artistaid` (PK): Identificador único do artista
- `nome_artista`: Nome do artista

---

### `playlist`
Gerencia as playlists dos usuários.
- `playlistid` (PK): Identificador único da playlist
- `titulo_playlist`: Nome da playlist
- `userid` (FK): Chave estrangeira para `usuarios_cadastrados`

---

### `relacao_playlist_musica`
Tabela de ligação que associa músicas a playlists.
- `playlistid` (FK): Chave estrangeira para `playlist`
- `musicaid` (FK): Chave estrangeira para `musicas_cadastradas`

---

### `historico_pesquisa_usuario`
Registra as pesquisas realizadas pelos usuários.
- `id_pesquisa` (PK): Identificador da pesquisa
- `pesquisa_feita`: Termo pesquisado
- `userid` (FK): Chave estrangeira para `usuarios_cadastrados`

---

### `relacao_user_curtida`
Tabela de ligação para registrar as músicas curtidas pelos usuários.
- `userid` (FK): Chave estrangeira para `usuarios_cadastrados`
- `musicaid` (FK): Chave estrangeira para `musicas_cadastradas`

---

### `historico_descurtidas`
Registra as músicas que foram curtidas e depois descurtidas pelos usuários.
- `id_descurtida` (PK): Identificador da descurtida
- `userid` (FK): Chave estrangeira para `usuarios_cadastrados`
- `musicaid` (FK): Chave estrangeira para `musicas_cadastradas`

---

### `relacao_user_descurtida`
Tabela de ligação para registrar as músicas atualmente descurtidas pelos usuários.
- `userid` (FK): Chave estrangeira para `usuarios_cadastrados`
- `musicaid` (FK): Chave estrangeira para `musicas_cadastradas`

# 3. Classes DAO
## ConexaoBD

Classe responsável por estabelecer a conexão com o banco de dados PostgreSQL.

- Encapsula os detalhes de conexão (URL, usuário e senha).
- Fornece o método `getConnection()` para obter uma instância de `Connection`, que será utilizada pelas outras classes DAO.

---

## MenuDAO

Classe que lida com as funcionalidades principais do menu do aplicativo.

### Métodos:
- `consultarMusicas()`: Buscar e listar todas as músicas cadastradas, incluindo informações do artista.
- `registrarPesquisa()`: Registrar o termo pesquisado pelo usuário no histórico de pesquisas.
- `curtirMusica()`: Adicionar uma música à lista de curtidas de um usuário.
- `descurtirMusica()`: Adicionar uma música à lista de descurtidas de um usuário.

---

## PerfilDAO

Focada nas operações relacionadas ao perfil do usuário e suas interações personalizadas.

### Métodos:
- `buscarMusicasCurtidas()`: Recuperar todas as músicas que um usuário curtiu.
- `buscarMusicasDescurtidas()`: Recuperar todas as músicas que um usuário descurtiu.
- `buscarHistoricoCuridasRemovidas()`: Listar as últimas músicas que foram descurtidas (removidas das curtidas).
- `removerCurtidaColarHistorico()`:  
  Remover uma música da lista de curtidas e registrá-la no histórico de descurtidas, utilizando uma **transação** para garantir a **atomicidade** da operação.
- `removerDescurtida()`: Remover uma música da lista de descurtidas.

---

## Gerenciamento de Playlists

Funcionalidades relacionadas às playlists do usuário.

### Métodos:
- `buscarPlaylistsDoUsuario()`: Listar todas as playlists criadas por um usuário.
- `criarNovaPlaylist()`: Criar uma nova playlist para o usuário.
- `adicionarMusicaNaPlaylist()`: Adicionar uma música a uma playlist específica.
- `buscarMusicasDaPlaylist()`: Listar todas as músicas contidas em uma playlist.
- `removerMusicaDaPlaylist()`: Remover uma música de uma playlist.
- `excluirPlaylist()`:  
  Excluir uma playlist e, **em uma transação**, remover todas as músicas associadas a ela antes de deletar a própria playlist.

---

## Login - UserDAO

Classe responsável pela gestão de usuários no banco de dados.

### Funcionalidades:
- `inserir()`: Cadastrar novos usuários.
- `consultar()`: Verificar credenciais para login

# 4. Classes Model

# Pasta `model` - Projeto Spotifei

A pasta `model` contém as classes que representam as entidades de negócio do projeto Spotifei, seguindo o padrão de arquitetura MVC (Model-View-Controller).

Essas classes são responsáveis por encapsular os dados, sem se preocupar com a interface do usuário ou com o acesso ao banco de dados.

---

## Classes Presentes

### `Artista.java`
- Representa a entidade Artista.
- Contém atributos como o nome do artista.

---

### `InterfaceAutenticacao.java`
- Define um contrato (interface) para classes que implementam lógica de autenticação.
- É utilizada pela classe `Usuario`.

---

### `Musica.java`
- Representa a entidade Música.
- Atributos incluem: título, álbum e informações do artista associado.

---

### `Pessoa.java`
- Classe com atributos de pessoa, como nome e outras características comuns.
- Pode servir como superclasse para outras entidades.

---

### `Playlist.java`
- Representa a entidade Playlist.
- Contém atributos como o título da playlist e o usuário proprietário.

---

### `Usuario.java`
- Representa a entidade Usuário.
- Atributos incluem: nome, username e senha.
- Implementa a interface `InterfaceAutenticacao`.

---

## Resumo

Essas classes formam o núcleo de dados da aplicação, definindo a estrutura e o comportamento dos objetos que são manipulados em todo o sistema.

As classes na pasta `controller` representam a **camada intermediária do padrão MVC**, sendo responsáveis por conectar a lógica de negócios (`model`) com a interface do usuário (`view`).

Esses controladores recebem as ações do usuário pela `view`, processam essas ações (geralmente com ajuda das classes `DAO` para acessar os dados) e atualizam a `view` conforme necessário.

---

# 5. Controladores

### `ControllerCadastro`
- Gerencia o processo de **cadastro de novos usuários**.
- Obtém os dados da tela de cadastro (`FrameCadastro`), cria um objeto `Usuario`, e usa `UserDAO` para persistir os dados no banco de dados.
- Exibe mensagens de **sucesso ou erro** com base na operação.

---

### `ControllerLogin`
- Controla o processo de **autenticação de usuários**.
- Recebe as credenciais da tela de login (`FrameLogin`) e tenta autenticar o usuário.
- A autenticação é realizada com o `UserDAO.consultar`.
- Em caso de sucesso, redireciona o usuário para a tela principal (`FrameMenu`).

---

### `ControllerPerfil`
- Controlador responsável pela **interface do perfil do usuário** (`FramePerfilUsuario`) e suas interações.
- Funcionalidades:
  - Exibição de **músicas curtidas e descurtidas**, com dados obtidos via `PerfilDAO`.
  - **Gerenciamento de curtidas/descurtidas**, incluindo remoção e atualização do histórico.
  - Exibição do **histórico de descurtidas**.
  - **Gerenciamento de playlists**: criação, adição e remoção de músicas, exclusão de playlists.
  - Criação dinâmica de componentes de interface, como `JComboBox` para seleção de playlists.

---

### `ControllerMenu`
- Gerencia a **tela principal** da aplicação (`FrameMenu`).
- Funcionalidades:
  - Lista e exibe todas as **músicas disponíveis**.
  - Permite **pesquisar músicas** por título, álbum ou artista e registra essas pesquisas no histórico.
  - Gerencia as ações de **curtir, descurtir** e **adicionar músicas a playlists**.
  - Utiliza `MenuDAO` e `PerfilDAO` para operações no banco de dados.
  - Exibe o **histórico de pesquisas** do usuário.

---
# 6. Frames da Interface

A pasta `view` contém todas as classes responsáveis pela **interface gráfica do usuário (GUI)** do aplicativo Spotifei, utilizando a biblioteca **Swing**.

Cada classe nesta pasta representa uma **tela** ou **componente visual** específico da aplicação.

### `FrameCadastro.java`
- Representa a **tela de cadastro**.
- Permite que novos usuários se **registrem no sistema**.

---

### `FrameLogin.java`
- Tela de **autenticação**.
- Usuários existentes inserem suas **credenciais** para acessar o aplicativo.

---

### `FrameMenu.java`
- Tela **principal da aplicação**, exibida após o login.
- O usuário pode:
  - **Buscar músicas**
  - **Curtir ou descurtir músicas**
  - **Acessar o perfil**
  - **Adicionar músicas a playlists**, entre outras funcionalidades.

---

### `FramePerfilUsuario.java`
- Tela dedicada ao **perfil do usuário**.
- Funcionalidades incluem:
  - Exibição de **músicas curtidas** e **descurtidas**
  - Acesso ao **histórico de interações**
  - **Gerenciamento de playlists**

---

## Resumo

A camada `view` é responsável por toda a **interação visual** com o usuário, fornecendo janelas intuitivas para navegação, ações e gerenciamento de conteúdo musical no Spotifei.
