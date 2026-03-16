# 📦 Database Migration Strategy

---

# 📖 Contexto

Em sistemas modernos, o **schema do banco de dados evolui continuamente junto com o código da aplicação**. Novas funcionalidades frequentemente exigem mudanças estruturais, como:

* criação de tabelas
* adição ou remoção de colunas
* criação de índices
* alteração de constraints
* correções de dados

Sem um mecanismo de controle dessas mudanças, é comum surgirem problemas como:

* divergência de schema entre ambientes
* dificuldade de reproduzir ambientes
* execução manual de scripts SQL
* perda de histórico das alterações

Para resolver esse problema, adotamos o uso de **migrations versionadas utilizando Flyway**.

---

# 🏗 Decisão Arquitetural

Adotar **controle de migrations de banco de dados versionadas utilizando Flyway**.

Todas as alterações estruturais ou de dados no banco devem ser feitas através de **scripts versionados armazenados junto ao código da aplicação**.

### Estrutura padrão das migrations

```text
db/migration

V1__create_user_table.sql
V2__add_email_column.sql
V3__create_order_table.sql
V4__populate_initial_data.sql