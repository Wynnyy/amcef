CREATE SCHEMA Amcef;

CREATE TABLE Amcef.Users (
ID int NOT NULL PRIMARY KEY,
USER_ID int,
TITLE varchar(255),
BODY varchar(500)
);

INSERT INTO Users (ID,USER_ID,TITLE,BODY) Values (1,1,'sunt aut facere repellat provident occaecati excepturi optio reprehenderit',
'quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto');

INSERT INTO Users (ID,USER_ID,TITLE,BODY) Values (2,1,'qui est esse',
'est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi nulla');

INSERT INTO Users (ID,USER_ID,TITLE,BODY) Values (3,1,'ea molestias quasi exercitationem repellat qui ipsa sit aut',
'et iusto sed quo iure\nvoluptatem occaecati omnis eligendi aut ad\nvoluptatem doloribus vel accusantium quis pariatur\nmolestiae porro eius odio et labore et velit aut');
