### Fatec - Centro Paula Souza
##### Curso - Desenvolvimento de Software Multiplataforma
##### Estudo de Caso – 
> No contexto do projeto interdisciplinar o estudo de caso tem como objetivo desenvolver e implantar o Sistema SIMUS. O projeto tem como objetivo facilitar o processo de matrícula dos alunos na instituição. Também gerenciar disciplinas, professores e as turmas dessa instituição, além de relátorios dos alunos para os funcionários

Time de desenvolvimento
- Douglas Nascimento
- Jackeline Menezes
- João Victor
- Victor Cardoso
  
##### Instalação
O projeto esta em desenvolvimento utilizando Visual Studio Code e a linguagem Java 17.
- No Github selecione a opção clone e copie o endereço do repositório.
- Na aba Source Control, selecione a opção Clone Repository
- Insira o URI do repositório na linha do comando do Visual Studio Code
- Selecione a pasta que deseja colocar o repositório
- Após abrir a pasta no Visual Studio Code, iniciar a classe contida em simus/src/main/java/com/pi/simus/SimusApplication.java
  
##### Processo de Desenvolvimento de Software - PDS
> O PDS segue uma abordagem interativa incremental adaptada do Scrum. A definição de pronto estabelece os mecanismos para
> controle de qualidade da aplicação.
##### Análise de risco
> O resultado da análise conclui que será possível implementar o projeto no semestre com grupos de alunos atuando como programadores. O maior risco identificado é a falta de tempo para reunião do time de desenvolvimento e estudo
do projeto. O grupo deve definir estratégias para mitigar o risco de dificuldades com a linguagem de programação, identificando membros do grupo com problemas na programação, selecionando videoaulas, referência bibliográficas, para
melhora a produtividade do time.
##### Product Backlog
> Cada requisito tem um identificador único de maneira que seja possível rastrear a necessidade do cliente com a implementação do software.
> | Identificador | Descrição | Complexidade|
> | ------------ | ------------------------------------------------------------------------ | ------|
> | RF01 - Inserir aluno | Como – Funcionário, Eu quero – Inserir aluno, De maneira que – O aluno possa acessar o sistema e para ter o controle dos alunos na escola | Alta |
> | RF02 - Alterar aluno | Como – Funcionário, Eu quero – Alterar aluno, De maneira que – O funcionário possa alterar os dados do alunos em caso de mudança de algum dado cadastral | Alta |
> | RF03 - Consultar aluno | Como – Funcionário, Eu quero – Consultar aluno, De maneira que – O funcionário possa visualizar todos os alunos, ou para achar alunos em especifico | Média |
> | RF04 - Excluir aluno | Como – Funcionário, Eu quero – Excluir aluno, De maneira que – O funcionário possa remover o registro de um aluno que não estuda mais na escola | Média |
> | RF05 - Inserir professor | Como – Funcionário, Eu quero – Inserir professor, De maneira que – O funcionário possa ter o controle dos professores, e para poder vinculá-los as disciplinas que vão ministrar  | Média |
> | RF06 - Alterar professor | Como – Funcionário, Eu quero – Alterar professor, De maneira que – O funcionário possa alterar os dados de um professor, em caso de mudança de algum dado cadastral | Média |
> | RF07 - Consultar professor | Como – Funcionário, Eu quero – Consultar professor, De maneira que – O funcionário possa visualizar os professores que estão dando aula, e quais disciplinas ele está ministrando  | Média |
> | RF08 - Excluir professor | Como – Funcionário, Eu quero – Excluir professor, De maneira que – O funcionário possa excluir um aluno que não atua mais como professor na escola  | Média |
> | RF09 - Inserir disciplina | Como – Funcionário, Eu quero – Inserir disciplina, De maneira que – O funcionário possa inserir as disciplinas que os alunos poderão se matricular na escola  | Média |
> | RF10 - Alterar disciplina | Como – Funcionário, Eu quero – Alterar disciplina, De maneira que – O funcionário possa alterar os dados de uma disciplina, caso necessário | Média |
> | RF11 - Consultar disciplina | Como – Funcionário, Eu quero – Consultar disciplina, De maneira que – O funcionário possa visualizar as disciplinas do curso, e as suas informações | Alta |
> | RF12 - Excluir disciplina | Como – Funcionário, Eu quero – Inserir professor, De maneira que – O funcionário possa remover uma disciplina que não será mais aplicada na escola | Média |
> | RF13 - Recuperação de acesso | Como – Aluno, Eu quero – Recuperar acesso, De maneira que – O aluno possa recuperar o acesso da sua conta, caso o tenha perdido | Média |
> | RF14 - Gerar lista de espera | Como – Aluno, Eu quero – Gerar lista de espera, De maneira que – O aluno que tentar se matricular em uma disciplina sem vagas, possa entrar na lista de espera | Alta |
> | RF15 - Gerar relatório de alunos | Como – Funcionário, Eu quero – Gerar relatório dos alunos, De maneira que – o funcionário possa ter a informação de quantidade de alunos matriculados por disciplina/turma | Alta |
> | RF16 - Contatar funcionários | Como – Aluno, Eu quero – Contatar funcionários, De maneira que – O aluno possa entrar com os funcionários caso haja um problema que é necessário atendimento direto | Baixa |
> | RF17 - Página de ajuda | Como – Aluno, Eu quero – Consultar a ajuda do site, De maneira que – O aluno tenha autonomia no uso do sistema, sem a necessidade de esperar ajuda externa para conseguir usar o sistema | Média |
> | RF18 - Trocar e-mail | Como – Aluno, Eu quero – Trocar o e-mail cadastrado, De maneira que – O aluno possa trocar seu e-mail e contato, sem depender do funcionário para fazer essa alteração | Alta |
> | RF19 - Trocar senha | Como – Aluno, Eu quero – Trocar minha senha , De maneira que – O aluno possa trocar sua senha de forma rápida, sem depender de um funcionário | Alta |
> | RF20 - Inserir matrícula | Como – Aluno, Eu quero – Inserir matrícula, De maneira que – O aluno possa se inscrever nas disciplinas que deseja (deve) cursar nesse semestre | Alta |
> | RF21 - Consultar matrícula  | Como – Aluno, Eu quero – Consultar matrícula, De maneira que – O aluno possa visualizar as disciplinas que ele se matriculou, e os respectivos horários/professores | Alta |
> | RF22 - Alterar matrícula | Como – Aluno, Eu quero – Alterar matrícula, De maneira que – O aluno possa alterar o horário/turma da disciplina desejada, caso esteja dentro do prazo estipulado | Alta |
> | RF23 - Excluir matrícula | Como – Aluno, Eu quero – Inserir Excluir matrícula, De maneira que – O aluno possa trancar a disciplina desejada, caso esteja dentro do prazo estipulado | Alta |
> | RF24 - Inserir boletim | Como – Funcionário, Eu quero – Inserir boletim, De maneira que – O funcionário possa inserir as notas dos alunos no sistema, para a futura consulta dos alunos | Média |
> | RF25 - Exibir boletim | Como – Aluno, Eu quero – Exibir boletim, De maneira que – O aluno possa visualizar as suas notas daquele semestre, e ver seu desempenho | Média |

##### Definição de pronto
> - Os itens do Product Backlog associados ao incremento dessa sprint estão concluídos
> - Todas as funcionalidades implementadas estão testadas e funcionando corretamente
> - O código está revisado e segue as diretrizes de codificação (Relatório SonarLint)
> - O código está armazenado no repositório do Github
