INSERT INTO source(name) SELECT DISTINCT source FROM test_data ORDER BY source ASC;

INSERT INTO topic(name) SELECT DISTINCT topic FROM test_data;

INSERT INTO news(name,source_id, topic_id) (SELECT news as name , 1 as sourse_id ,1 as topic_id FROM test_data WHERE id=1);
INSERT INTO news(name,source_id, topic_id) (SELECT news as name , 1 as sourse_id ,1 as topic_id FROM test_data WHERE id=2);
INSERT INTO news(name,source_id, topic_id) (SELECT news as name , 1 as sourse_id ,2 as topic_id FROM test_data WHERE id=3);
INSERT INTO news(name,source_id, topic_id) (SELECT news as name , 1 as sourse_id ,3 as topic_id FROM test_data WHERE id=4);
INSERT INTO news(name,source_id, topic_id) (SELECT news as name , 1 as sourse_id ,3 as topic_id FROM test_data WHERE id=5);
INSERT INTO news(name,source_id, topic_id) (SELECT news as name , 1 as sourse_id ,3 as topic_id FROM test_data WHERE id=6);
INSERT INTO news(name,source_id, topic_id) (SELECT news as name , 2 as sourse_id ,4 as topic_id FROM test_data WHERE id=7);
INSERT INTO news(name,source_id, topic_id) (SELECT news as name , 2 as sourse_id ,4 as topic_id FROM test_data WHERE id=8);