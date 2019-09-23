BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "ovi" (
	"id"	INTEGER NOT NULL,
	"index"	TEXT,
	"abhang"	TEXT
);
INSERT INTO "ovi" VALUES (1,'१','
नमोजी पंढरिराया । हत्कमलवासीया गुरुनाथा ॥१॥
तुमचा अनुग्रह लाधलों । पात्र झालों महा सुखा ॥२॥
सकळ संत करिती कृपा । दाविला सोपा निज मार्ग ॥३॥ 
निळा म्हणे दिवस रात्रीं । गातों वक्त्रीं गुण नाम ॥४॥/');
INSERT INTO "ovi" VALUES (2,'२','
सकळा मंगळांचे धाम । ज्याचेनि विश्राम विश्रांती ॥१॥
तो हा पंढरीचा रावो । सकळां ठावो कल्याणा ॥२॥
ज्याचेनी सुखा सुखपण । ज्याचेनी त्रिभुवन रुपस ॥३॥ 
निळा म्हणे ज्याचेनि निगमा । आणिली गरिमा जाणिवेची ॥४॥');
COMMIT;
