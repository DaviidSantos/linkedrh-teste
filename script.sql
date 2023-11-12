CREATE TABLE curso(
                      codigo SERIAL PRIMARY KEY,
                      nome VARCHAR(100) NOT NULL,
                      descricao VARCHAR(4000) NOT NULL,
                      duracao INTEGER NOT NULL
);

CREATE TABLE funcionario(
                            codigo SERIAL PRIMARY KEY,
                            nome VARCHAR(200) NOT NULL,
                            cpf CHAR(11) NOT NULL,
                            nascimento DATE NOT NULL,
                            cargo VARCHAR(200) NOT NULL,
                            admissao DATE NOT NULL,
                            status BIT NOT NULL
);

CREATE TABLE turma(
                      codigo SERIAL PRIMARY KEY,
                      inicio DATE NOT NULL,
                      fim DATE NOT NULL,
                      local VARCHAR(200),
                      curso INTEGER REFERENCES curso(codigo) ON DELETE CASCADE
);

CREATE TABLE turma_participante(
                                   codigo SERIAL PRIMARY KEY,
                                   turma INTEGER REFERENCES turma(codigo) ON DELETE CASCADE,
                                   funcionario INTEGER REFERENCES funcionario(codigo)ON DELETE CASCADE
);
