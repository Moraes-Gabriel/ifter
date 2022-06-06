

insert into usuario (email, identify, nick_name, senha, birth_Date) 
values ('gabriel.moraes@cwi.com.br', 'moraes24', 'moraes'
	,'$2a$10$hJJiFP/A7PtCYmc6rewzuu2eJAzrmJNISjCuBavz.x6iMf7tB9Aiy','24/04/2003');

insert into usuario (email, identify, nick_name, senha, birth_Date) 
values ('everton.zanatta@cwi.com.br', 'zanatta24', 'zanatta'
	,'$2a$10$hJJiFP/A7PtCYmc6rewzuu2eJAzrmJNISjCuBavz.x6iMf7tB9Aiy','24/04/2003');


insert into usuario (email, identify, nick_name, senha, birth_Date) 
values ('gabriel.alves@cwi.com.br', 'alves24', 'alves'
	, '$2a$10$hJJiFP/A7PtCYmc6rewzuu2eJAzrmJNISjCuBavz.x6iMf7tB9Aiy','24/04/2003');

insert into usuario (email, identify, nick_name, senha, birth_Date) 
values ('andre.souza@cwi.com.br', 'souza24', 'souza'
	, '$2a$10$hJJiFP/A7PtCYmc6rewzuu2eJAzrmJNISjCuBavz.x6iMf7tB9Aiy','24/04/2003');
		
insert into usuario (email, identify, nick_name, senha, birth_Date) 
values ('bruno.alves@cwi.com.br', 'bruno24', 'bruno'
	,'$2a$10$hJJiFP/A7PtCYmc6rewzuu2eJAzrmJNISjCuBavz.x6iMf7tB9Aiy','24/04/2003');
	
	insert into usuario (email, identify, nick_name, senha, birth_Date) 
values ('gregori.nunes@cwi.com.br', 'nunes24', 'nunes'
	,'$2a$10$hJJiFP/A7PtCYmc6rewzuu2eJAzrmJNISjCuBavz.x6iMf7tB9Aiy','24/04/2003');
		
	insert into usuario (email, identify, nick_name, senha, birth_Date) 
values ('vinicius.stanguerlin@cwi.com.br', 'stanguerlin24', 'stanguerlin'
	,'$2a$10$hJJiFP/A7PtCYmc6rewzuu2eJAzrmJNISjCuBavz.x6iMf7tB9Aiy','24/04/2003');

	insert into permissao (nome, user_id)
	values ('USER',1); 
	insert into permissao (nome, user_id)
	values ('USER',2);
	insert into permissao (nome, user_id)
	values ('USER',3);
	insert into permissao (nome, user_id)
	values ('USER',4);
	insert into permissao (nome, user_id)
	values ('USER',5);
	
	insert into post(category,date_creation,description,usuario_id)
	values ('PUBLIC', '2022-03-31 10:27:18.953015'
			,'Um bom dia para jogar um league of legends hoje na aula',1);
			
	insert into post(category,date_creation,description,usuario_id)
	values ('PUBLIC', '2022-03-31 10:27:18.953015'
			,'A aula foi espetacular',1);
			
	insert into post(category,date_creation,description,usuario_id)
	values ('PRIV', '2022-03-31 10:27:18.953015'
			,'Sinto que precisavamos desse tempo para falar mal dos outros ',1);
			
	insert into post(category,date_creation,description,usuario_id)
	values ('PUBLIC', '2022-03-31 10:27:18.953015'
			,'EU ME SUPREENDO O QUAO O MORAES É UM BOM ALUNO ',2);
			
	insert into post(category,date_creation,description,usuario_id)
	values ('PUBLIC', '2022-03-31 10:27:18.953015'
			,'Hoje o gabriel foi excepicional na aula ',3);
			
	insert into post(category,date_creation,description,usuario_id)
	values ('PUBLIC', '2022-03-31 10:27:18.953015'
			,'MELHOR ALUNO ',3);
			
	insert into post(category,date_creation,description,usuario_id)
	values ('PRIV', '2022-03-31 10:27:18.953015'
			,'MENTIRA ELE É UM ALUNO HORRIVEL',2);
			
			
	insert into post(category,date_creation,description,usuario_id)
	values ('PUBLIC', '2022-03-31 10:27:18.953015'
			,'PEGUEI FRUTINHAS',2);
			
	insert into post(category,date_creation,description,usuario_id)
	values ('PUBLIC', '2022-03-31 10:27:18.953015'
			,'ESSE CAJAR TEM GOSTO DE CAMARIM',2);
			
	insert into post(category,date_creation,description,usuario_id)
	values ('PUBLIC', '2022-03-31 10:27:18.953015'
			,'QUEM FREIA BATE NO POSTE',3);
			
	insert into post(category,date_creation,description,usuario_id)
	values ('PUBLIC', '2022-03-31 10:27:18.953015'
			,'DEMOROU JA',3);
			
	insert into post(category,date_creation,description,usuario_id)
	values ('PRIV', '2022-03-31 10:27:18.953015'
			,'MINHA PRIVADA EMProPRIU',3);
			
	insert into post(category,date_creation,description,usuario_id)
	values ('PUBLIC', '2022-03-31 10:27:18.953015'
			,'MONARK E FODA',6);
			
	insert into post(category,date_creation,description,usuario_id)
	values ('PUBLIC', '2022-03-31 10:27:18.953015'
			,'CELULAR ANDROID E UMA BOS**',6);
			
	insert into post(category,date_creation,description,usuario_id)
	values ('PUBLIC', '2022-03-31 10:27:18.953015'
			,'O MONITOR DA CWI É TODO BUGADO',6);
			
	insert into post(category,date_creation,description,usuario_id)
	values ('PRIV', '2022-03-31 10:27:18.953015'
			,'MEU MAIOR SONHO É PASSAR NO CRESCER PARA AMIGOS',6);
			
			
	insert into user_friendly(friend_solicited_id, friend_accept_id)
	values(1,2);
	
	insert into user_friendly(friend_solicited_id, friend_accept_id)
	values(2,1);
	
	insert into user_friendly(friend_solicited_id, friend_accept_id)
	values(1,3);
	
	insert into user_friendly(friend_solicited_id, friend_accept_id)
	values(3,1);
	
	insert into user_friendly(friend_solicited_id, friend_accept_id)
	values(2,3);
	
	insert into user_friendly(friend_solicited_id, friend_accept_id)
	values(3,2);
	

	insert into user_relations(followed_id, follower_id)
	values(1,2);
	
	insert into user_relations(followed_id, follower_id)
	values(2,1);
	
	insert into user_relations(followed_id, follower_id)
	values(1,3);
	
	insert into user_relations(followed_id, follower_id)
	values(3,1);
	
	insert into user_relations(followed_id, follower_id)
	values(2,3);
	
	insert into user_relations(followed_id, follower_id)
	values(3,2);
	



select * from user_relations









