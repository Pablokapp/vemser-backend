CREATE TABLE VEM_SER.ESTUDANTE (
	id_estudante NUMBER(6) NOT NULL,
	nome VARCHAR2(200) NOT NULL,
	data_nascimento DATE NOT NULL,
	nr_matricula NUMBER(10) UNIQUE NOT NULL,
	ativo CHAR(1),
	PRIMARY KEY	(id_estudante)
);

CREATE SEQUENCE VEM_SER.seq_estudante
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

CREATE SEQUENCE VEM_SER.seq_estudante_matricula
START WITH 1000
INCREMENT BY 1
NOCACHE NOCYCLE;

INSERT INTO VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (VEM_SER.SEQ_ESTUDANTE.nextval, 'José Pereira', TO_DATE('01-09-1994', 'dd-mm-yyyy'), VEM_SER.seq_estudante_matricula.nextval , 'S');
		
INSERT INTO	VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES 	(VEM_SER.seq_estudante.nextval, 'João Santos', TO_DATE('09-07-1989', 'dd-mm-yyyy'), VEM_SER.seq_estudante_matricula.nextval, 'N');
		
INSERT INTO	VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (VEM_SER.seq_estudante.nextval, 'Adroaldo Antunes', TO_DATE('12-06-1988', 'dd-mm-yyyy'), VEM_SER.seq_estudante_matricula.nextval, 'S');
		
INSERT INTO	VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (VEM_SER.seq_estudante.nextval, 'William Souza', TO_DATE('01-09-1998', 'dd-mm-yyyy'), VEM_SER.seq_estudante_matricula.nextval, 'S');
		
INSERT INTO	VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (VEM_SER.seq_estudante.nextval, 'Nestor Teixeira', TO_DATE('07-04-1978', 'dd-mm-yyyy'), VEM_SER.seq_estudante_matricula.nextval, 'S');
		
INSERT INTO	VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (VEM_SER.seq_estudante.nextval, 'Marcela Nunes', TO_DATE('17-09-1974', 'dd-mm-yyyy'), VEM_SER.seq_estudante_matricula.nextval, 'S');
		
INSERT INTO	VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (VEM_SER.seq_estudante.nextval, 'Juliane Lacerda', TO_DATE('21-05-1994', 'dd-mm-yyyy'), VEM_SER.seq_estudante_matricula.nextval, 'S');
	
INSERT INTO	VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (VEM_SER.seq_estudante.nextval, 'Mariana Souza', TO_DATE('04-08-1994', 'dd-mm-yyyy'), VEM_SER.seq_estudante_matricula.nextval, 'S');
	
INSERT INTO	VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (VEM_SER.seq_estudante.nextval, 'Marina Lourenço', TO_DATE('08-05-1988', 'dd-mm-yyyy'), VEM_SER.seq_estudante_matricula.nextval, 'S');
		
INSERT INTO	VEM_SER.ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo)
VALUES (VEM_SER.seq_estudante.nextval, 'Bárbara Luiza', TO_DATE('19-05-1997', 'dd-mm-yyyy'), VEM_SER.seq_estudante_matricula.nextval, 'S');
	
SELECT * FROM VEM_SER.ESTUDANTE;

SELECT NOME, DATA_NASCIMENTO AS Nascimento, NR_MATRICULA AS Matricula FROM VEM_SER.ESTUDANTE;

SELECT NOME, NR_MATRICULA || ' - ' || ATIVO AS "SITUAÇÃO" FROM VEM_SER.ESTUDANTE;