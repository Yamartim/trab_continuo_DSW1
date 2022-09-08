# Web1-T2
## Sistema para compra e venda de pacotes turísticos

### Roteiro para execução
O SGBD utilizado foi o MySQL com o login `usuario: root` e a `senha: root`
O banco de dados é criado e populado apenas com o usuario administrador que possui o email: admin@email.com e senha: admin

Para executar a aplicação basta rodar: `mvn spring-boot:run`

mysql workbench 
se der acesso negado é so mudar a senha Roo1T#, tanto do banco quanto no codigo.

para alterar precisa executar o mysql no terminal: sudo mysql
depois precisa executar esse comando para alterar a senha 

ALTER USER 'root'@'localhost'
IDENTIFIED WITH mysql_native_password BY 'your_new_password';

a senha tem um formato, se nao estiver indo é so olha nesse comando qual o padrão
SHOW VARIABLES LIKE 'validate_password%';

e se quiser mudar alguma coisa desse padrão é so rodar os comandos assim
SET GLOBAL validate_password.length = 6;
SET GLOBAL validate_password.number_count = 0;

se alterar a senha é necessario mudar nesse arquivo tambem application.properties que se econtra dentro de resources

spring.datasource.password = Roo1T#
