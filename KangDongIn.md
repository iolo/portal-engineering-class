데이터베이스: `twitterkdi`

CREATE TABLE IF NOT EXISTS `user` (
> `id` varchar(50) COLLATE utf8\_bin NOT NULL,
> `password` varchar(50) COLLATE utf8\_bin NOT NULL,
> `name` varchar(50) COLLATE utf8\_bin NOT NULL,
> `memo` text COLLATE utf8\_bin NOT NULL,
> `image` varchar(256) COLLATE utf8\_bin NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8\_bin;