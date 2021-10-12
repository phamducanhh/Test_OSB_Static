GO
if exists (select * from sysdatabases where name='Library')
		drop database Library
GO

CREATE DATABASE Library
GO

USE [Library]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[UserTBL]    Script Date: 4/29/2019 3:05:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[User](
	[username] [varchar](150) NOT NULL,
	[password] [varchar](150) NOT NULL,
	[role] [int] NOT NULL
 CONSTRAINT [PK_UserTBL] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
/***** Insert Table User *****/

INSERT [dbo].[User] ([username], [password], [role]) VALUES (N'admin', N'admin', 0)
INSERT [dbo].[User] ([username], [password], [role]) VALUES (N'guest1', N'123',1)
INSERT [dbo].[User] ([username], [password], [role]) VALUES (N'guest2', N'456',1)
INSERT [dbo].[User] ([username], [password], [role]) VALUES (N'guest3', N'789',1)
/***** Object Table Book *****/
CREATE TABLE [dbo].[Book](
   [id]          VARCHAR(10) NOT NULL PRIMARY KEY
  ,[name]        VARCHAR(150) NOT NULL
  ,[image]       VARCHAR(200)
  ,[authorId]    VARCHAR(10)
  ,[publisherId] VARCHAR(10)
  ,[description] VARCHAR(1000) NOT NULL
  ,[price]      FLOAT(2) NOT NULL
);
/***** Insert Table Book *****/
INSERT INTO Book([id],[name],[image],[authorId],[publisherId],[description],[price]) VALUES ('AAIWDL0001','Alice''s Adventures in Wonderland','AAIWDL0001.png','LWSCRRL001','PBLSHR0001','On an ordinary summer''s afternoon, Alice tumbles down a hole and an extraordinary adventure begins. In a strange world with even stranger characters, she meets a grinning cat and a rabbit with a pocket watch, joins a Mad Hatter''s Tea Party, and plays croquet with the Queen! Lost in this fantasy land, Alice finds herself growing more and more curious by the minute . . .With a brilliant introduction by Chris Riddell, Alice''s Adventures in Wonderland is one of twenty much-loved classic stories relaunched with gorgeous new covers. The book includes a behind-the-scenes journey, including an author profile, a guide to who''s who, activities and more.',129.00);
INSERT INTO Book([id],[name],[image],[authorId],[publisherId],[description],[price]) VALUES ('TTMKTR0002','The Three Musketeers','TTMKTR0002.png','ALXDDMS001','PBLSHR0001','Alexandre Dumas’s enthralling novel, set during the reign of Louis XIII, is the tale of a poor Gascon of noble descent intent on joining the legendary King’s Musketeers. This fabulous edition of one of literature’s greatest adventures, strictly limited to 750 copies, is bound in goatskin leather blocked in black and gold foils and features a signed and numbered etching by Roman Pisarev.',159.00);
INSERT INTO Book([id],[name],[image],[authorId],[publisherId],[description],[price]) VALUES ('DRCULA0003','Dracula','DRCULA0003.png','BRMSTKR001','PBLSHR0001','There can be few novels as influential as Bram Stoker’s much-adapted vampire tale. For this, the ultimate collector’s edition, artist Angela Barrett has produced 15 intensely atmospheric colour plates, a set of elaborate hand-drawn borders, nine black-and-white tailpieces, and a pair of striking designs on the venous red leather binding and black cloth-covered slipcase.',219.00);
INSERT INTO Book([id],[name],[image],[authorId],[publisherId],[description],[price]) VALUES ('LTPOTH0004','The Letterpress Othello','LTPOTH0004.png','SHKSPER001','PBLSHR0001','Shakespeare’s explosive tale of love, jealousy and betrayal follows the triumphs and eventual downfall of the noble General Othello – his love for Desdemona, his trust in the villainous Iago and his obsessive jealousy that leads to murder. The sheer visceral strength of this great tragedy has resonated through the centuries, ensuring it remains one of Shakespeare’s most popular plays.',439.00);
INSERT INTO Book([id],[name],[image],[authorId],[publisherId],[description],[price]) VALUES ('PTMOPR0005','Phantom of the Opera','PTMOPR0005.png','GSTLROX001','PBLSHR0002','Mysterious goings-on at the Paris opera house are brushed aside by its new owners, but the old-timers know that the resident ghost is more than an urban legend. One of the greatest gothic horror novels ever written, Gaston Leroux’s atmospheric adventure still chills first-time readers, then lures them back time and time again. Long eclipsed by the huge popularity of its musical adaptation, the book once again takes centre stage in this lavish new edition that drips with macabre imagery and theatrical allusion.',349.00);
INSERT INTO Book([id],[name],[image],[authorId],[publisherId],[description],[price]) VALUES ('MISERY0006','Misery','MISERY0006.png','STPNKNG001','PBLSHR0002','Author Paul Sheldon regains consciousness in a stranger’s guest room, his legs shattered and useless. As the intense pain ebbs and flows, rare moments of lucidity lead to the chilling realisation that his rescuer is also his jailer. Annie Wilkes might be Paul’s ‘number one fan’, but she is incensed that he has killed the heroine Misery Chastain in his latest novel. Fate has given Annie a chance to bring her favourite character back to life, and Paul won’t be leaving Annie’s remote farmstead alive until he complies. Misery sees Stephen King at the height of his writing powers in a novel that explores the psyche of an author suffering extreme torment. Edward Kinsella illustrated the best-selling Folio edition of The Shining and he again immerses himself in King’s narrative to create a terrifying and compelling set of illustrations, as well as a binding design that defines the novel: the antique Royal typewriter that is both Paul Sheldon’s entrapment and his only hope of liberty.',359.00);
INSERT INTO Book([id],[name],[image],[authorId],[publisherId],[description],[price]) VALUES ('MNGNGE0007','Midnight in the Garden of Good and Evil','MNGNGE0007.png','JHNBRNT001','PBLSHR0002','The ‘Bird Girl’ image, a photograph of the bronze statue that once stood in Bonaventure cemetery, now adorns the binding of this new edition. Jack Leigh’s iconic photograph featured on the 1994 first edition dust jacket and is synonymous with the book. More of Leigh’s original images of Savannah have been beautifully reproduced alongside seven further atmospheric photographs by Georgian photographers. Like courtroom evidence, the series of ten atmospheric photographs offer tantalising snapshots of the Old South and the city that captured the imagination of millions.',239.00);
INSERT INTO Book([id],[name],[image],[authorId],[publisherId],[description],[price]) VALUES ('THSHNG0008','The Shining','THSHNG0008.png','STPNKNG001','PBLSHR0002','Jack Torrance is the new winter caretaker of the Overlook, a grand hotel nestled in the isolated Colorado mountains and cut off from civilisation during the harsh cold months. Here, with his wife Wendy and their son Danny, Jack attempts to escape the mistakes of his past and rebuild a life with his family. But the hotel has other ideas. Using Danny’s strange precognitive gift – his ’hining’ – the evil that lurks inside the Overlook begins to stir, and take hold …',359.00);
INSERT INTO Book([id],[name],[image],[authorId],[publisherId],[description],[price]) VALUES ('CSTLAI0009','Castle in the Air','CSTLAI0009.png','DNWNJHN001','PBLSHR0002','Diana Wynne Jones’s sequel to the much-loved Howl’s Moving Castle explores more of her gorgeously imaginative world, taking the story to a distant land infused with the flavours of The Arabian Nights. Castle in the Air tells the sort of fairy tale only Jones could – warm, clever and enriched with humour, like gold silk in a magical carpet. Marie-Alice Harel, winner of the ninth Book Illustration Competition, returns with more of her exquisite artwork, including six gorgeous full colour images, black-and-white chapter head illustrations, and a wraparound binding design that floats the impossible castle of the title across a night’s sky of silvery stars. This beautiful edition of Castle in the Air also features delicately glittering endpapers depicting the gardens of Abdullah’s dreams, and a splendid decorated slipcase.',59.00);
INSERT INTO Book([id],[name],[image],[authorId],[publisherId],[description],[price]) VALUES ('HWMVCS0010','Howl''s Moving Castle','HWMVCS0010.png','DNWNJHN001','PBLSHR0002','A magical union of make-believe and reality, this much-loved young-adult fantasy spirits the reader off to faraway lands with an evil witch, a dashing wizard and an adventurous teenage girl. Folio’s charming new edition celebrates master storyteller Diana Wynne Jones’s creativity, alongside that of Folio’s 2019 Book Illustration Competition winner. Selected from a record-breaking 500 entries from around the world, Marie-Alice Harel re-enchants the fairy-tale tradition with her series of six images created with a lilac-themed palate. Harel also introduces the book’ 21 chapters with delicate black-and-white decorations that offer tantalising clues to the story, while the binding shows heroine Sophie Hatter being magnetically drawn to the gloomy castle of the title, with its mysterious four-fold aspect.',59.00);
INSERT INTO Book([id],[name],[image],[authorId],[publisherId],[description],[price]) VALUES ('HOBBIT0011','The Hobbit','HOBBIT0011.png','JRRTKEN001','PBLSHR0002','Bilbo Baggins is a reasonably typical hobbit: fond of sleeping, eating, drinking, parties and presents. However, it is his destiny to travel to the dwarflands in the east, to help slay the dragon Smaug. His quest takes him through enchanted forests, spiders’ lairs, and under the Misty Mountains, where he comes across the vile Gollum, and tricks him out of his ’Precious’ - a ring that makes its bearer invisible, and wields a terrible power of its own.',259.00);
INSERT INTO Book([id],[name],[image],[authorId],[publisherId],[description],[price]) VALUES ('LRDRNG0012','The Lord of the Rings','LRDRNG0012.png','JRRTKEN001','PBLSHR0002','The original ‘fantasy’ series, and still the greatest, The Lord of the Rings has sold over 100 million copies, been translated into more than 40 languages, and has been voted the best book of the 20th century. If there is any work of fiction that deserves to be owned in a magnificent edition – this is surely it.',599.00);
INSERT INTO Book([id],[name],[image],[authorId],[publisherId],[description],[price]) VALUES ('SLMRLN0013','The Silmarillion','SLMRLN0013.png','JRRTKEN001','PBLSHR0002','J. R. R. Tolkien began creating the mythology, traditions and language of Middle-earth long before The Lord of the Rings and The Hobbit ever found their way onto the printed page. Known as The Silmarillion, a book Tolkien would add to throughout his life, this rich tapestry of tales told of the creation of the world in the First Age, the coming of Elves and Men, the theft of the Silmarils – the jewels containing the pure light that illuminated Middle-earth – and the wars between the first Dark Lord and the High Elves.',259.00);
INSERT INTO Book([id],[name],[image],[authorId],[publisherId],[description],[price]) VALUES ('ACLKNG0014','A Clash of Kings','ACLKNG0014.png','GRGRRMT001','PBLSHR0002','The fight for the Iron Throne heats up in A Clash of Kings. George R. R. Martin barely gives the reader time to recover from the shocks of the first book as four potential kings come into contention. Meanwhile, our favourite characters face extraordinary trials simply to survive. Following on from The Folio Society’s wildly successful edition of A Game of Thrones, this unique two-volume set is packed with details that fans will love, including specially designed chapter headings and spectacular bindings. Jonathan Burton returns to capture all the grandeur, spectacle and emotion, with six colour illustrations and a double-page spread in each volume. Described by Martin as ‘masterpieces of the bookmaker’ art’, these are the finest editions of this generation’s most celebrated fantasy series, and if the first volume is anything to go by, A Clash of Kings will soon be as rare as dragon eggs.',259.00);
INSERT INTO Book([id],[name],[image],[authorId],[publisherId],[description],[price]) VALUES ('ASTMSW0015','A Storm of Swords','ASTMSW0015.png','GRGRRMT001','PBLSHR0002','The bloodiest, boldest and most addictive saga in fantasy continues with A Storm of Swords, the third volume in the ground-breaking ‘A Song of Ice and Fire’ series. Taking the world by storm, George R. R. Martin’s fantasy epic has won millions of fans worldwide, and these Folio editions – described by the author as ‘masterpieces of the bookmaker’ art’ – are packed full of details that devoted readers will find irresistible. Featuring exquisite illustrations by series artist Jonathan Burton, updated genealogies, a pair of bindings blocked in red and gold foils and specially designed chapter headings, this edition of A Storm of Swords exemplifies everything that makes a Folio edition so coveted.',259.00);
INSERT INTO Book([id],[name],[image],[authorId],[publisherId],[description],[price]) VALUES ('OLWMSH0016','Outlaws of the Marsh','OLWMSH0016.png','SHNAIAN001','PBLSHR0002','Originally related by oral tradition, Outlaws of the Marsh was first transcribed in the 14th century and is the earliest of the four Great Classics of Chinese Literature. From supernatural feats of endurance to tales of poisoning, witchcraft and cannibalism, the timeless tales of villainy and heroism have engrossed whole generations and still provide inspiration for comic books, films, Peking opera and computer games.',799.00);
INSERT INTO Book([id],[name],[image],[authorId],[publisherId],[description],[price]) VALUES ('GDFTHR0017','The Godfather','GDFTHR0017.png','MRIOPZO001','PBLSHR0002','One of the best-selling books of all time, it is almost impossible to exaggerate the influence that Mario Puzo’s genre-defining novel has had on popular culture since its publication in 1969. From Francis Ford Coppola’s phenomenally successful film trilogy and a slew of deferential movies and television series, to gangland parlance and schoolyard banter, its legacy is multiple and global. This glorious new edition is packed with carefully considered design details that pay homage to Puzo’s epic story and its era. From the bleeding upside-down New York skyline on the binding to the series of dramatic tableaux and portraits by award-winning illustrator Robert Carter, and Jonathan Freedland’s new introduction, this is the edition that every Godfather aficionado has been waiting for.',179.00);
INSERT INTO Book([id],[name],[image],[authorId],[publisherId],[description],[price]) VALUES ('CRKHSE0018','Crooked House','CRKHSE0018.png','AGTCRTE001','PBLSHR0003','A mysterious poisoning. A house full of eccentric characters. And one amateur sleuth racing to fit all of the crooked pieces together. Crooked House is the epitome of an Agatha Christie novel – in fact, Christie herself described it as one of her own ‘special favourites’. Acknowledged the world over as the undisputed queen of crime, Christie composed the plot of Crooked House with all her usual brilliance, teasing the reader with multiple red herrings and canny psychological insights before leading them to a resolution that still has the power to shock, even today. This edition features seven evocative colour illustrations by artist Sally Dunne that perfectly capture the 1940s period and country-house setting, as well as a binding design that, like Christie’s writing, is both beautiful and sinister.',129.00);
INSERT INTO Book([id],[name],[image],[authorId],[publisherId],[description],[price]) VALUES ('MDRRGA0019','The Murder of Roger Ackroyd','MDRRGA0019.png','AGTCRTE001','PBLSHR0003','Proclaimed by the Crime Writers’ Association as ‘the finest example of the genre ever penned’, The Murder of Roger Ackroyd contains one of the most celebrated twists in crime fiction and is consistently voted among Agatha Christie’s best novels. It is, famously, the Poirot novel that demands to be read twice: the curious reader cannot resist re-examining what they thought they knew. Laura Thompson, Christie’s biographer, described it as ‘masterly: deceptive in every way’, and it remains a rare treat for those who savour the challenge of a whodunnit, yet love to be taken in by a master of her craft.',129.00);
INSERT INTO Book([id],[name],[image],[authorId],[publisherId],[description],[price]) VALUES ('FVLTPG0020','Five Little Pigs','FVLTPG0020.png','AGTCRTE001','PBLSHR0003','As a trained apothecary’s assistant who worked for the Red Cross during the First World War, it’s no coincidence that Agatha Christie chose poisoning as the cause of death for many of her fictional victims. This time it’s the turn of artist and serial philanderer Amyas Crale, and his long-suffering wife Caroline is convicted of his murder. When the case is revisited sixteen years later, Poirot’s instinct for injustice is piqued and he gathers fresh testimonies from the only other possible suspects – the Five Little Pigs. Widely regarded as one of Christie’s greatest murder mysteries and one of Poirot’s most compelling cases, in this gorgeous new Folio edition Five Little Pigs is illustrated by award-winning artist Andrew Davidson, including a striking silhouette binding design that offers a tantalising clue to the case.',129.00);
INSERT INTO Book([id],[name],[image],[authorId],[publisherId],[description],[price]) VALUES ('ATTWNN0021','And Then There Were None','ATTWNN0021.png','AGTCRTE001','PBLSHR0003','Ten people are invited to an island by a host that none of them has met. A recorded voice accuses each of them of a crime for which they were never punished. And then the dying begins. Cut off from the world, there is no escape from each other, or from themselves. And where no one is innocent, anyone might be the murderer, or the next victim …',129.00);
INSERT INTO Book([id],[name],[image],[authorId],[publisherId],[description],[price]) VALUES ('MMPSST0022','Miss Maple Short Stories','MMPSST0022.png','AGTCRTE001','PBLSHR0003','When a group of friends in a small village – artists, writers and clergymen – decide to tell unsolved mysteries to each other at Miss Jane Marple’s house, they expect little in the way of a contribution from their elderly host. So when she lifts her eyes from her knitting to deduce the truth about a case of domestic poisoning, they are flabbergasted. As the stories in this collection are told – disappearing bloodstains, the cryptic last message of a poisoned man, a spiritualist who predicts death – Miss Marple’s reputation grows, and before long she is being asked for help by the police. This complete collection features all 20 short stories, including ‘The Tuesday Night Club’, ‘A Christmas Tragedy’ and ‘The Case of the Perfect Maid’. They are neatly encapsulated by Henry Clithering’s cry at the solution of ‘Ingots of Gold’: ‘Miss Marple, you are wonderful!’',129.00);

/***** Object Table Author *****/
CREATE TABLE [dbo].[Author](
   [authorId]    VARCHAR(10) NOT NULL PRIMARY KEY
  ,[name]        VARCHAR(50)
  ,[description] VARCHAR(200)
);

/***** Insert Table Author *****/
INSERT INTO Author([authorId],[name],[description]) VALUES ('LWSCRRL001','Lewis Carroll','https://en.wikipedia.org/wiki/Lewis_Carroll');
INSERT INTO Author([authorId],[name],[description]) VALUES ('ALXDDMS001','Alexandre Dumas','https://en.wikipedia.org/wiki/Alexandre_Dumas');
INSERT INTO Author([authorId],[name],[description]) VALUES ('BRMSTKR001','Bram Stoker','https://en.wikipedia.org/wiki/Bram_Stoker');
INSERT INTO Author([authorId],[name],[description]) VALUES ('SHKSPER001','William Shakespeare','https://en.wikipedia.org/wiki/William_Shakespeare');
INSERT INTO Author([authorId],[name],[description]) VALUES ('GSTLROX001','Gaston Leroux','https://en.wikipedia.org/wiki/Gaston_Leroux');
INSERT INTO Author([authorId],[name],[description]) VALUES ('STPNKNG001','Stephen King','https://en.wikipedia.org/wiki/Stephen_King');
INSERT INTO Author([authorId],[name],[description]) VALUES ('JHNBRNT001','John Berendt','https://en.wikipedia.org/wiki/John_Berendt');
INSERT INTO Author([authorId],[name],[description]) VALUES ('DNWNJHN001','Diana Wynne Jones','https://en.wikipedia.org/wiki/Diana_Wynne_Jones');
INSERT INTO Author([authorId],[name],[description]) VALUES ('JRRTKEN001','J. R. R. Tolkien','https://en.wikipedia.org/wiki/J._R._R._Tolkien');
INSERT INTO Author([authorId],[name],[description]) VALUES ('GRGRRMT001','George R. R. Martin','https://en.wikipedia.org/wiki/George_R._R._Martin');
INSERT INTO Author([authorId],[name],[description]) VALUES ('SHNAIAN001','Shi Nai''an','https://en.wikipedia.org/wiki/Shi_Nai%27an');
INSERT INTO Author([authorId],[name],[description]) VALUES ('MRIOPZO001','Mario Puzo','https://en.wikipedia.org/wiki/Mario_Puzo');
INSERT INTO Author([authorId],[name],[description]) VALUES ('AGTCRTE001','Agatha Christie','https://en.wikipedia.org/wiki/Agatha_Christie');

/***** Object Table Publisher *****/
CREATE TABLE [dbo].[Publisher](
   [publisherId]    VARCHAR(10) NOT NULL PRIMARY KEY
  ,[name]        VARCHAR(50)
  ,[description] VARCHAR(200)
);

/***** Insert Table Publisher *****/
INSERT INTO Publisher([publisherId],[name],[description]) VALUES ('PBLSHR0001','Simon & Schuster','https://en.wikipedia.org/wiki/Simon_%26_Schuster');
INSERT INTO Publisher([publisherId],[name],[description]) VALUES ('PBLSHR0002','Constable & Robinson','https://en.wikipedia.org/wiki/Constable_%26_Robinson');
INSERT INTO Publisher([publisherId],[name],[description]) VALUES ('PBLSHR0003','Collins Crime Club','https://en.wikipedia.org/wiki/Collins_Crime_Club');

/***** Object Table Genre *****/
CREATE TABLE [dbo].[Genre](
  [GenreId] int NOT NULL PRIMARY KEY,
  [name] VARCHAR(50),
)

/***** Insert Table Genre *****/
INSERT INTO Genre([GenreId],[name]) VALUES (1,'Children');
INSERT INTO Genre([GenreId],[name]) VALUES (2,'Fiction');
INSERT INTO Genre([GenreId],[name]) VALUES (3,'Non-Fiction');
INSERT INTO Genre([GenreId],[name]) VALUES (4,'Historical');
INSERT INTO Genre([GenreId],[name]) VALUES (5,'Action');
INSERT INTO Genre([GenreId],[name]) VALUES (6,'Mystery');
INSERT INTO Genre([GenreId],[name]) VALUES (7,'Horror');
INSERT INTO Genre([GenreId],[name]) VALUES (8,'Romance');

/***** Object Table Book_Genre *****/
CREATE TABLE [dbo].[Book_Genre](
  [id] VARCHAR(10) NOT NULL,
  [GenreId] int  NOT NULL,
  
  CONSTRAINT [PK_Book_Genre] PRIMARY KEY CLUSTERED 
(
	[id] ASC,
	[GenreId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

/***** Object Table OrderLine *****/
CREATE TABLE [dbo].[OrderLine](
  [billId] int NOT NULL,
  [id] nvarchar(10)  NOT NULL,
  [quantity] int NOT NULL,
  CONSTRAINT [PK_OrderLine] PRIMARY KEY CLUSTERED 
(
	[billId] ASC,
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

/***** Object Table Bill *****/
CREATE TABLE [dbo].[Bill](
  [billId] int primary key IDENTITY(1,1) NOT NULL,
  [name] varchar(100) NOT NULL,
  [email] varchar(100),
  [address] varchar(200) NOT NULL,
  [zipcode] varchar(10) NOT NULL,
  [tel] varchar(12) NOT NULL,
  [note] varchar(1000),
  [payment] varchar(50),
  [date] date,
  [ship] bit,
)
/***** Insert Table Book_Genre *****/
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('AAIWDL0001',1);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('AAIWDL0001',2);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('TTMKTR0002',3);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('TTMKTR0002',4);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('TTMKTR0002',5);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('DRCULA0003',2);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('DRCULA0003',7);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('LTPOTH0004',2);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('LTPOTH0004',8);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('PTMOPR0005',2);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('PTMOPR0005',7);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('PTMOPR0005',8);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('MISERY0006',2);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('MISERY0006',7);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('MNGNGE0007',2);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('MNGNGE0007',7);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('THSHNG0008',2);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('THSHNG0008',7);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('CSTLAI0009',1);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('CSTLAI0009',2);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('CSTLAI0009',8);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('HWMVCS0010',1);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('HWMVCS0010',2);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('HWMVCS0010',8);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('HOBBIT0011',2);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('HOBBIT0011',5);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('HOBBIT0011',6);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('HOBBIT0011',8);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('LRDRNG0012',2);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('LRDRNG0012',5);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('LRDRNG0012',6);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('LRDRNG0012',8);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('SLMRLN0013',2);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('SLMRLN0013',5);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('SLMRLN0013',6);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('SLMRLN0013',8);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('ACLKNG0014',2);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('ACLKNG0014',5);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('ACLKNG0014',6);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('ACLKNG0014',8);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('ASTMSW0015',2);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('ASTMSW0015',5);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('ASTMSW0015',6);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('ASTMSW0015',8);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('OLWMSH0016',2);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('OLWMSH0016',4);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('OLWMSH0016',5);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('OLWMSH0016',8);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('GDFTHR0017',2);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('GDFTHR0017',5);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('CRKHSE0018',2);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('CRKHSE0018',6);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('MDRRGA0019',2);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('MDRRGA0019',6);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('FVLTPG0020',2);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('FVLTPG0020',6);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('ATTWNN0021',2);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('ATTWNN0021',6);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('MMPSST0022',2);
INSERT INTO Book_Genre([id],[GenreId]) VALUES ('MMPSST0022',6);
/***** End Script *****/

