insert into Client_Inventory
    (Client_ID, ISBN, Date_Purchased, Last_Modified, Is_Removed)
values (1, "9780142000670", "2019-09-23 20:12:21", "2019-12-03 13:10:57", false);
insert into Client_Inventory
    (Client_ID, ISBN, Date_Purchased, Last_Modified, Is_Removed)
values (2, "9780439244190", "2019-07-30 09:07:25", "2019-11-21 03:44:42", true);
insert into Client_Inventory
    (Client_ID, ISBN, Date_Purchased, Last_Modified, Is_Removed)
values (3, "9780061120084", "2019-07-31 04:43:51", "2020-01-17 13:26:36", true);
insert into Client_Inventory
    (Client_ID, ISBN, Date_Purchased, Last_Modified, Is_Removed)
values (5, "9780684830421", "2019-02-20 18:01:43", "2020-01-19 22:00:21", true);
insert into Client_Inventory
    (Client_ID, ISBN, Date_Purchased, Last_Modified, Is_Removed)
values (6, "9780606323451", "2019-06-27 19:25:11", "2020-01-23 10:17:10", true);
insert into Client_Inventory
    (Client_ID, ISBN, Date_Purchased, Last_Modified, Is_Removed)
values (7, "9780451526342", "2019-02-04 16:09:05", "2020-01-28 12:23:04", false);
insert into Client_Inventory
    (Client_ID, ISBN, Date_Purchased, Last_Modified, Is_Removed)
values (8, "9780316769174", "2019-09-09 07:42:48", "2019-12-08 09:22:52", false);
insert into Client_Inventory
    (Client_ID, ISBN, Date_Purchased, Last_Modified, Is_Removed)
values (9, "9780439023481", "2019-10-29 11:40:03", "2019-12-07 14:32:38", false);
insert into Client_Inventory
    (Client_ID, ISBN, Date_Purchased, Last_Modified, Is_Removed)
values (3, "9780307277671", "2019-06-09 06:25:36", "2020-01-18 15:59:11", true);
insert into Client_Inventory
    (Client_ID, ISBN, Date_Purchased, Last_Modified, Is_Removed)
values (9, "9781594480003", "2019-03-26 11:41:09", "2020-01-16 19:26:31", true);
insert into Client_Inventory
    (Client_ID, ISBN, Date_Purchased, Last_Modified, Is_Removed)
values (1, "9780140283334", "2019-11-02 05:22:34", "2020-01-20 21:52:39", false);
insert into Client_Inventory
    (Client_ID, ISBN, Date_Purchased, Last_Modified, Is_Removed)
values (2, "9780679601685", "2019-07-26 09:03:28", "2019-12-24 19:12:04", false);
insert into Client_Inventory
    (Client_ID, ISBN, Date_Purchased, Last_Modified, Is_Removed)
values (9, "9780062315007", "2019-03-05 02:58:01", "2019-11-22 17:17:23", false);
insert into Client_Inventory
    (Client_ID, ISBN, Date_Purchased, Last_Modified, Is_Removed)
values (6, "9780770430078", "2019-07-12 17:36:50", "2020-01-11 21:44:51", true);
insert into Client_Inventory
    (Client_ID, ISBN, Date_Purchased, Last_Modified, Is_Removed)
values (20, "9780375831003", "2019-09-09 01:05:41", "2020-01-17 04:50:54", true);
insert into Client_Inventory
    (Client_ID, ISBN, Date_Purchased, Last_Modified, Is_Removed)
values (6, "9780307588371", "2019-05-25 03:18:44", "2019-12-30 13:25:30", false);
insert into Client_Inventory
    (Client_ID, ISBN, Date_Purchased, Last_Modified, Is_Removed)
values (5, "9781416524793", "2019-03-23 03:03:35", "2020-01-28 15:29:58", true);

insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("21777", "9780142000670", 2, "Poisoning by antiviral drugs, intentional self-harm",
        "Poisoning by antiviral drugs, intentional self-harm", 52, 2, false, false, "2019-03-15 12:51:02",
        "2019-09-22 14:47:10", "2020-03-11 08:39:40");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("3", "9780061120084", 2, "Puncture wound with foreign body, unspecified thigh, sequela",
        "Puncture wound with foreign body, unspecified thigh, sequela", 82, 65, false, false, "2019-04-20 15:59:37",
        "2019-01-20 09:07:35", "2020-03-03 08:53:49");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("7", "9780439023481", 3,
        "Nondisplaced oblique fracture of shaft of humerus, right arm, subsequent encounter for fracture with nonunion",
        "Nondisp oblique fx shaft of humer, r arm, 7thK", 90, 18, false, false, "2019-04-30 19:00:59",
        "2019-07-26 12:04:33", "2020-03-15 13:13:46");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("46807", "9780375831003", 1,
        "Displaced fracture of medial phalanx of left ring finger, subsequent encounter for fracture with nonunion",
        "Disp fx of med phalanx of l rng fngr, subs for fx w nonunion", 70, 30, true, false, "2019-04-27 06:32:32",
        "2019-02-15 04:28:26", "2020-03-13 21:02:12");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("14416", "9780141439471", 3, "Gastrointestinal stromal tumor of rectum",
        "Gastrointestinal stromal tumor of rectum", 34, 66, false, false, "2019-08-30 21:23:27", "2019-01-14 22:11:32",
        "2020-03-06 06:44:35");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("4073", "9780770430078", 4, "Displacement of internal fixation device of vertebrae, initial encounter",
        "Displacement of internal fixation device of vertebrae, init", 55, 1, false, true, "2019-03-22 18:56:14",
        "2019-10-07 02:08:47", "2020-03-15 02:23:18");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("429", "9780143039983", 2, "Laceration with foreign body of left index finger with damage to nail, sequela",
        "Laceration w fb of l idx fngr w damage to nail, sequela", 53, 6, false, true, "2019-12-25 12:30:36",
        "2019-06-24 13:25:19", "2020-03-18 14:28:08");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("07", "9780062200570", 1, "Follicular cyst of ovary, unspecified side",
        "Follicular cyst of ovary, unspecified side", 53, 59, true, true, "2019-07-31 03:14:33", "2019-11-13 16:50:05",
        "2020-03-04 17:08:07");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("28", "9780345504968", 3, "Myelodysplastic disease, not classified", "Myelodysplastic disease, not classified",
        32, 38, true, false, "2020-01-19 21:47:58", "2019-04-27 02:05:48", "2020-03-02 05:31:05");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("37652", "9780062259660", 2, "Borderline leprosy", "Borderline leprosy", 10, 80, true, false,
        "2019-07-14 23:31:46", "2019-05-11 22:48:31", "2020-03-18 07:11:38");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("09", "9780141439471", 2, "Osteochondritis dissecans, unspecified knee",
        "Osteochondritis dissecans, unspecified knee", 69, 68, false, false, "2019-04-11 09:00:48",
        "2019-01-27 11:39:26", "2020-03-23 08:22:43");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("0320", "9781982110567", 1, "Other mucopurulent conjunctivitis, left eye",
        "Other mucopurulent conjunctivitis, left eye", 12, 30, false, false, "2019-09-25 02:03:04",
        "2019-05-12 08:28:28", "2020-03-29 01:44:51");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("3", "9780316323703", 1, "Encounter for routine child health examination without abnormal findings",
        "Encntr for routine child health exam w/o abnormal findings", 76, 41, false, false, "2019-08-02 12:21:11",
        "2019-05-23 01:41:02", "2020-03-15 13:10:32");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("16", "9780316166683", 1, "Obstructed labor due to breech presentation, fetus 3",
        "Obstructed labor due to breech presentation, fetus 3", 17, 27, false, true, "2019-12-23 23:13:05",
        "2019-09-11 16:27:55", "2020-03-11 01:42:57");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("3", "9780060584757", 4, "Malignant neoplasm of left olfactory nerve",
        "Malignant neoplasm of left olfactory nerve", 83, 81, false, false, "2019-03-16 23:10:54",
        "2019-07-03 22:50:15", "2020-03-01 03:28:59");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("3", "9780307346605", 4, "Poisoning by inhaled anesthetics, intentional self-harm",
        "Poisoning by inhaled anesthetics, intentional self-harm", 46, 33, true, true, "2019-05-01 13:41:19",
        "2019-02-09 01:47:56", "2020-03-17 05:58:14");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("98830", "9780593099322", 2, "Periradicular pathology associated with previous endodontic treatment",
        "Periradicular pathology assoc w previous endodontic trtmt", 87, 70, true, true, "2019-04-22 20:25:04",
        "2019-08-23 16:32:37", "2020-03-24 09:03:43");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("21", "9780553803716", 5, "Injury of peroneal nerve at lower leg level, right leg",
        "Injury of peroneal nerve at lower leg level, right leg", 31, 68, false, true, "2019-08-24 19:54:29",
        "2019-08-31 02:56:22", "2020-03-21 01:47:39");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("8", "9780062024039", 4,
        "Monoplegia of lower limb following nontraumatic intracerebral hemorrhage affecting left dominant side",
        "Monoplg low lmb fol ntrm intcrbl hemor aff left dom side", 16, 94, false, true, "2019-11-17 07:41:05",
        "2019-10-10 07:31:46", "2020-03-25 15:43:58");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("07", "9781451673319", 3,
        "Displaced fracture of hook process of hamate [unciform] bone, right wrist, subsequent encounter for fracture with routine healing",
        "Disp fx of hook pro of hamate bone, r wrs, 7thD", 93, 27, true, true, "2019-11-10 01:18:58",
        "2019-04-14 04:34:10", "2020-03-16 13:12:58");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("21", "9780553803709", 1,
        "Burn of unspecified degree of single right finger (nail) except thumb, initial encounter",
        "Burn unsp degree of single r finger except thumb, init", 86, 2, true, true, "2019-02-06 03:54:46",
        "2019-05-12 22:36:42", "2020-03-03 05:23:36");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("311", "9780999851135", 1, "Other and unspecified edema specific to newborn",
        "Other and unspecified edema specific to newborn", 91, 7, false, true, "2019-09-01 04:17:26",
        "2019-01-14 11:18:01", "2020-03-26 22:14:41");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("51", "9780765311788", 5,
        "Other fracture of upper and lower end of unspecified fibula, subsequent encounter for open fracture type I or II with nonunion",
        "Oth fx upr & low end unsp fibula, 7thM", 94, 85, true, false, "2019-04-20 23:31:04", "2019-03-14 15:19:14",
        "2020-03-26 11:08:32");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("32336", "9780698165083", 1, "Corrosion of first degree of unspecified forearm, subsequent encounter",
        "Corrosion of first degree of unsp forearm, subs encntr", 62, 57, false, false, "2019-04-24 21:21:51",
        "2019-11-27 08:52:45", "2020-03-20 03:47:15");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("952", "9780356507217", 5, "Trigger finger, unspecified ring finger", "Trigger finger, unspecified ring finger",
        64, 53, false, true, "2019-04-07 14:42:10", "2019-10-16 05:36:17", "2020-03-09 05:49:49");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("483", "9780440000587", 2, "Problems related to housing and economic circumstances",
        "Problems related to housing and economic circumstances", 33, 31, true, true, "2019-07-27 05:39:31",
        "2019-03-20 05:01:56", "2020-03-20 01:51:11");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("9044", "9780143039983", 3,
        "Adverse effect of centrally-acting and adrenergic-neuron-blocking agents, initial encounter",
        "Adverse effect of centr-acting/adren-neurn-block agnt, init", 9, 82, false, false, "2019-02-24 06:43:41",
        "2020-01-03 12:47:04", "2020-03-07 11:05:29");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("25", "9780679745587", 5,
        "Displaced fracture of left tibial tuberosity, subsequent encounter for open fracture type IIIA, IIIB, or IIIC with malunion",
        "Disp fx of l tibial tuberosity, 7thR", 68, 37, true, false, "2019-12-17 09:37:13", "2019-04-11 10:34:18",
        "2020-03-09 17:20:12");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("2", "9780143034902", 3, "Toxic effect of homologues of benzene, accidental (unintentional), initial encounter",
        "Toxic effect of homologues of benzene, accidental, init", 69, 4, true, true, "2019-07-07 15:48:24",
        "2019-10-24 23:48:02", "2020-03-09 08:03:26");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("0", "9780752865331", 1, "Transection (partial) of abdomen", "Transection (partial) of abdomen", 61, 88, true,
        true, "2020-01-30 15:00:30", "2020-01-17 19:31:32", "2020-03-28 21:15:52");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("5", "9780375831003", 5, "Assault by unspecified means", "Assault by unspecified means", 81, 64, false, false,
        "2019-03-23 14:31:32", "2019-02-27 03:43:16", "2020-03-21 22:10:25");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("447", "9780770430078", 4, "Toxic effect of unspecified snake venom, intentional self-harm, initial encounter",
        "Toxic effect of unsp snake venom, self-harm, init", 64, 18, true, true, "2019-07-19 04:12:28",
        "2019-05-15 19:24:54", "2020-03-13 23:34:26");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("543", "9780770430078", 4,
        "Unspecified open wound of left back wall of thorax without penetration into thoracic cavity, initial encounter",
        "Unsp opn wnd l bk wl of thorax w/o penet thor cavity, init", 44, 18, true, false, "2019-03-04 02:43:45",
        "2019-07-05 16:01:31", "2020-03-17 00:25:43");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("31957", "9780727860996", 5, "Breakdown (mechanical) of artificial skin graft and decellularized allodermis",
        "Breakdown of artificial skin grft /decellular alloderm", 53, 86, true, true, "2020-01-19 19:52:48",
        "2019-01-19 15:49:30", "2020-03-03 15:23:06");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("6020", "9780316323703", 5,
        "Poisoning by unspecified agents primarily affecting the gastrointestinal system, assault, subsequent encounter",
        "Poisoning by unsp agents aff the GI sys, assault, subs", 42, 9, false, true, "2019-06-25 14:36:54",
        "2019-08-05 23:33:15", "2020-03-17 23:41:01");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("7512", "9780582418271", 2, "Leakage of vascular dialysis catheter, sequela",
        "Leakage of vascular dialysis catheter, sequela", 44, 83, true, false, "2019-09-06 16:22:47",
        "2019-11-14 05:32:32", "2020-03-06 08:06:17");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("69007", "9780525945567", 4,
        "Person on outside of car injured in collision with sport utility vehicle in traffic accident",
        "Person on outside of car injured in collision w SUV in traf", 41, 57, false, true, "2019-04-19 12:10:08",
        "2019-05-23 17:03:30", "2020-03-28 07:28:10");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("50185", "9780593099322", 3, "Salter-Harris Type II physeal fracture of lower end of ulna, unspecified arm",
        "Sltr-haris Type II physeal fx lower end of ulna, unsp arm", 9, 11, true, false, "2019-11-25 19:02:33",
        "2020-01-07 01:26:34", "2020-03-19 12:04:14");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("928", "9780061007224", 1,
        "Laceration with foreign body of left little finger with damage to nail, subsequent encounter",
        "Laceration w fb of l little finger w damage to nail, subs", 29, 83, false, false, "2019-02-23 16:21:40",
        "2019-05-12 15:35:05", "2020-03-10 02:28:55");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("650", "9780061139376", 1,
        "Displaced fracture of medial phalanx of right ring finger, subsequent encounter for fracture with malunion",
        "Disp fx of med phalanx of r rng fngr, subs for fx w malunion", 37, 75, false, true, "2019-08-23 14:50:34",
        "2019-08-22 02:26:26", "2020-03-08 07:16:30");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("4563", "9780141439471", 4, "Breakdown (mechanical) of prosthetic orbit of right eye",
        "Breakdown (mechanical) of prosthetic orbit of right eye", 65, 9, false, false, "2019-05-05 04:48:29",
        "2019-07-18 20:31:06", "2020-03-04 21:56:12");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("0", "9780812976144", 1, "Other complications of other transplanted tissue",
        "Other complications of other transplanted tissue", 52, 37, false, true, "2019-08-21 17:38:41",
        "2020-01-08 07:48:01", "2020-03-23 23:28:12");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("00808", "9780553803716", 3,
        "Dislocation of metacarpophalangeal joint of right index finger, initial encounter",
        "Dislocation of MCP joint of right index finger, init", 44, 92, false, false, "2019-10-29 01:25:12",
        "2019-12-22 05:19:52", "2020-03-09 00:11:40");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("3406", "9780999851104", 4, "Toxic effect of fiberglass, accidental (unintentional), sequela",
        "Toxic effect of fiberglass, accidental, sequela", 67, 4, false, true, "2019-10-07 21:16:03",
        "2019-10-12 01:56:44", "2020-03-23 10:04:50");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("70", "9780999851135", 1, "Asphyxiation due to smothering in furniture, assault, sequela",
        "Asphyx due to smothering in furniture, assault, sequela", 70, 74, false, true, "2019-10-03 17:15:50",
        "2019-12-27 18:29:03", "2020-03-11 07:48:56");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("465", "9781937007720", 1, "Other chondrocalcinosis, right hand", "Other chondrocalcinosis, right hand", 74, 45,
        false, true, "2019-07-26 08:36:05", "2019-09-16 08:16:07", "2020-03-01 23:52:31");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("247", "9780425275757", 2, "Struck by other mammals", "Struck by other mammals", 99, 3, false, true,
        "2019-04-23 18:31:08", "2019-09-12 08:28:34", "2020-03-26 13:02:31");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("53604", "9780743298025", 4,
        "Maternal care for known or suspected placental insufficiency, second trimester, other fetus",
        "Matern care for known or susp placntl insuff, 2nd tri, oth", 11, 7, false, false, "2019-05-26 15:23:53",
        "2019-10-24 14:00:53", "2020-03-09 08:49:18");
insert into Customer_Reviews
(Client_ID, ISBN, Rating, Review_Body, Review_Title, Upvotes, Downvotes, Is_Removed, Pending, Last_Modified,
 Date_Entered, Date_Removed)
values ("7882", "9780743298025", 3, "Salter-Harris Type IV physeal fracture of upper end of radius, unspecified arm",
        "Sltr-haris Type IV physeal fx upper end radius, unsp arm", 56, 71, false, false, "2019-04-04 13:59:42",
        "2019-04-23 12:34:30", "2020-03-04 09:08:14");

insert into publisher
(Name, Address, City, Country, Postal_Code, Contact_Name, Phone_Number, Date_Created, Last_Modified, Is_Removed)
values ("Hauck-Crona", "5745 Sheridan Park", "Majingklak", "Indonesia", "China", "Minnie Rutter", "1247146795",
        "2019-02-06 23:13:29", "2019-10-28 08:46:16", false);
insert into publisher
(Name, Address, City, Country, Postal_Code, Contact_Name, Phone_Number, Date_Created, Last_Modified, Is_Removed)
values ("Rippin LLC", "7967 Sugar Way", "VillamarÃ­a", "Colombia", "Czech Republic", "Gail Tidd", "1585705675",
        "2019-03-28 03:40:10", "2019-10-30 11:01:30", false);
insert into publisher
(Name, Address, City, Country, Postal_Code, Contact_Name, Phone_Number, Date_Created, Last_Modified, Is_Removed)
values ("Vandervort Inc", "372 Huxley Terrace", "Tireman Timur", "Indonesia", "Ukraine", "Ollie Carmont", "5342235936",
        "2019-07-19 14:33:12", "2019-12-16 00:11:59", false);
insert into publisher
(Name, Address, City, Country, Postal_Code, Contact_Name, Phone_Number, Date_Created, Last_Modified, Is_Removed)
values ("Schimmel-Dooley", "5 Redwing Plaza", "Nicosia", "Cyprus", "Tunisia", "Ruthanne Macklam", "1649807197",
        "2019-05-19 06:28:44", "2019-11-10 19:41:06", false);
insert into publisher
(Name, Address, City, Country, Postal_Code, Contact_Name, Phone_Number, Date_Created, Last_Modified, Is_Removed)
values ("Haley, O''Reilly and Hintz", "1295 Miller Court", "Ivanivka", "Ukraine", "Albania", "Wynnie Daybell",
        "5437151409", "2019-05-11 09:44:54", "2019-09-27 14:00:20", false);
insert into publisher
(Name, Address, City, Country, Postal_Code, Contact_Name, Phone_Number, Date_Created, Last_Modified, Is_Removed)
values ("O''Hara-Grant", "4 Sunbrook Road", "Panayagan", "Indonesia", "Nigeria", "Claudine Dove", "6697746709",
        "2019-01-31 18:32:05", "2019-11-03 21:03:26", false);
insert into publisher
(Name, Address, City, Country, Postal_Code, Contact_Name, Phone_Number, Date_Created, Last_Modified, Is_Removed)
values ("Trantow, Bauch and Hegmann", "34198 Pleasure Center", "Barajalan", "Indonesia", "Belarus", "Lek Blackler",
        "4059690203", "2019-04-07 02:44:22", "2019-11-05 16:14:32", false);
insert into publisher
(Name, Address, City, Country, Postal_Code, Contact_Name, Phone_Number, Date_Created, Last_Modified, Is_Removed)
values ("Farrell, Jakubowski and White", "26 Kropf Street", "Abastumani", "Georgia", "Brazil", "Cecelia McCudden",
        "5404493249", "2019-06-21 04:52:26", "2019-11-07 14:09:57", false);
insert into publisher
(Name, Address, City, Country, Postal_Code, Contact_Name, Phone_Number, Date_Created, Last_Modified, Is_Removed)
values ("Okuneva LLC", "67 Transport Alley", "Holboo", "Mongolia", "Albania", "Wendie Ferreo", "5828283499",
        "2019-07-01 00:51:28", "2019-12-28 16:33:47", false);
insert into publisher
(Name, Address, City, Country, Postal_Code, Contact_Name, Phone_Number, Date_Created, Last_Modified, Is_Removed)
values ("Friesen-Bednar", "3 Merry Place", "Mayanhe", "China", "Brazil", "Ronica Mogg", "2991202293",
        "2019-08-28 02:53:43", "2019-11-28 10:36:26", false);
insert into publisher
(Name, Address, City, Country, Postal_Code, Contact_Name, Phone_Number, Date_Created, Last_Modified, Is_Removed)
values ("Roob Group", "7071 Grover Terrace", "Takahashi", "Japan", "Egypt", "Berri Maron", "7247747966",
        "2019-08-04 06:58:16", "2020-01-28 20:19:29", false);
insert into publisher
(Name, Address, City, Country, Postal_Code, Contact_Name, Phone_Number, Date_Created, Last_Modified, Is_Removed)
values ("Lebsack, Homenick and Ratke", "0063 Independence Junction", "Zhongshan", "China", "Syria", "Nappie Ellins",
        "7514445538", "2019-08-26 03:57:29", "2019-09-12 17:24:52", false);
insert into publisher
(Name, Address, City, Country, Postal_Code, Contact_Name, Phone_Number, Date_Created, Last_Modified, Is_Removed)
values ("Pagac LLC", "9 Sunfield Center", "Jingyang", "China", "Liechtenstein", "Daniel Janczewski", "2847865338",
        "2019-04-30 23:54:03", "2019-11-26 12:46:42", false);
insert into publisher
(Name, Address, City, Country, Postal_Code, Contact_Name, Phone_Number, Date_Created, Last_Modified, Is_Removed)
values ("Tremblay-Bergnaum", "1 Mesta Road", "Pyatigorsk", "Russia", "Estonia", "Kora Capstack", "2079810300",
        "2019-08-06 20:19:59", "2020-01-16 10:35:08", false);
insert into publisher
(Name, Address, City, Country, Postal_Code, Contact_Name, Phone_Number, Date_Created, Last_Modified, Is_Removed)
values ("Marquardt, Cremin and Auer", "5047 Sheridan Place", "Zhongshanlu", "China", "China", "Antony Stonehouse",
        "8323729129", "2019-07-07 22:14:58", "2019-10-13 03:07:05", false);
insert into publisher
(Name, Address, City, Country, Postal_Code, Contact_Name, Phone_Number, Date_Created, Last_Modified, Is_Removed)
values ("Corwin-Tromp", "1 Nobel Center", "Chiguirip", "Peru", "Indonesia", "Sampson Wheatcroft", "5752034120",
        "2019-06-06 17:38:30", "2020-01-21 17:11:28", false);
insert into publisher
(Name, Address, City, Country, Postal_Code, Contact_Name, Phone_Number, Date_Created, Last_Modified, Is_Removed)
values ("Hand, Roberts and Little", "69 Arrowood Road", "Tianxing", "China", "Slovenia", "Cherise Laurentin",
        "5046081267", "2019-07-10 22:31:23", "2019-10-05 04:13:15", false);
insert into publisher
(Name, Address, City, Country, Postal_Code, Contact_Name, Phone_Number, Date_Created, Last_Modified, Is_Removed)
values ("Hand-Schoen", "0 Stoughton Street", "Jiuxian", "China", "Greece", "Burt Ellerton", "3409057194",
        "2019-03-14 00:46:46", "2020-01-03 06:33:28", false);
insert into publisher
(Name, Address, City, Country, Postal_Code, Contact_Name, Phone_Number, Date_Created, Last_Modified, Is_Removed)
values ("Muller, Lesch and Robel", "85347 Summit Place", "Cungapmimbo", "Indonesia", "Philippines", "Jayson Robberecht",
        "9027507183", "2019-02-18 14:16:31", "2019-11-27 12:21:39", false);
insert into publisher
(Name, Address, City, Country, Postal_Code, Contact_Name, Phone_Number, Date_Created, Last_Modified, Is_Removed)
values ("Yost-Halvorson", "02633 2nd Lane", "Soanindrariny", "Madagascar", "United States", "Roman Gofton",
        "1868061441", "2019-04-21 07:55:00", "2020-01-15 04:49:20", false);

insert into Orders
    (Client_ID, Date_Created, Last_Updated, Is_Removed)
values (1, "2019-06-23 05:26:50", "2020-01-10 17:52:40", true);
insert into Orders
    (Client_ID, Date_Created, Last_Updated, Is_Removed)
values (2, "2019-03-05 06:10:06", "2020-01-02 11:07:33", true);
insert into Orders
    (Client_ID, Date_Created, Last_Updated, Is_Removed)
values (3, "2019-07-30 02:37:49", "2019-12-30 07:29:14", false);
insert into Orders
    (Client_ID, Date_Created, Last_Updated, Is_Removed)
values (4, "2019-03-14 13:17:48", "2019-12-17 17:47:07", true);
insert into Orders
    (Client_ID, Date_Created, Last_Updated, Is_Removed)
values (5, "2019-10-31 07:44:31", "2020-01-18 20:43:21", true);
insert into Orders
    (Client_ID, Date_Created, Last_Updated, Is_Removed)
values (6, "2019-06-20 09:13:26", "2019-11-25 08:31:17", false);
insert into Orders
    (Client_ID, Date_Created, Last_Updated, Is_Removed)
values (7, "2019-03-07 13:21:18", "2019-12-20 20:01:33", true);
insert into Orders
    (Client_ID, Date_Created, Last_Updated, Is_Removed)
values (8, "2019-03-11 05:47:50", "2020-01-20 03:31:17", false);
insert into Orders
    (Client_ID, Date_Created, Last_Updated, Is_Removed)
values (9, "2019-04-15 17:48:34", "2019-12-30 15:46:28", true);
insert into Orders
    (Client_ID, Date_Created, Last_Updated, Is_Removed)
values (10, "2019-05-31 01:50:19", "2019-12-29 07:40:12", true);
insert into Orders
    (Client_ID, Date_Created, Last_Updated, Is_Removed)
values (11, "2019-04-13 01:28:41", "2019-11-26 10:19:09", true);
insert into Orders
    (Client_ID, Date_Created, Last_Updated, Is_Removed)
values (12, "2019-08-31 19:05:59", "2020-01-16 07:28:03", true);
insert into Orders
    (Client_ID, Date_Created, Last_Updated, Is_Removed)
values (13, "2019-03-20 00:57:30", "2019-12-20 11:02:05", true);
insert into Orders
    (Client_ID, Date_Created, Last_Updated, Is_Removed)
values (14, "2019-08-25 14:34:58", "2019-12-03 08:57:41", false);
insert into Orders
    (Client_ID, Date_Created, Last_Updated, Is_Removed)
values (15, "2019-09-13 23:27:23", "2019-12-09 20:00:31", false);
insert into Orders
    (Client_ID, Date_Created, Last_Updated, Is_Removed)
values (16, "2019-05-18 16:46:49", "2020-01-15 21:58:48", false);
insert into Orders
    (Client_ID, Date_Created, Last_Updated, Is_Removed)
values (17, "2019-04-23 12:55:04", "2019-11-19 04:50:36", false);
insert into Orders
    (Client_ID, Date_Created, Last_Updated, Is_Removed)
values (18, "2019-09-02 03:26:36", "2019-11-26 13:33:17", true);
insert into Orders
    (Client_ID, Date_Created, Last_Updated, Is_Removed)
values (19, "2019-03-29 23:21:54", "2019-11-30 07:12:30", false);
insert into Orders
    (Client_ID, Date_Created, Last_Updated, Is_Removed)
values (20, "2019-05-21 08:14:38", "2019-11-22 16:22:09", true);

insert into Order_Item
    (Order_ID, ISBN, Price_Sold, Last_updated, Is_Removed)
values (1, "9780142000670", 10, "2019-05-29 12:35:00", false);
insert into Order_Item
    (Order_ID, ISBN, Price_Sold, Last_updated, Is_Removed)
values (2, "9780439244190", 15, "2019-03-10 10:04:33", false);
insert into Order_Item
    (Order_ID, ISBN, Price_Sold, Last_updated, Is_Removed)
values (3, "9780061120084", 12, "2019-10-06 07:52:40", true);
insert into Order_Item
    (Order_ID, ISBN, Price_Sold, Last_updated, Is_Removed)
values (5, "9780684830421", 13, "2019-02-10 23:28:39", false);
insert into Order_Item
    (Order_ID, ISBN, Price_Sold, Last_updated, Is_Removed)
values (6, "9780606323451", 12, "2019-05-11 08:19:21", true);
insert into Order_Item
    (Order_ID, ISBN, Price_Sold, Last_updated, Is_Removed)
values (7, "9780451526342", 14, "2019-09-21 09:10:10", false);
insert into Order_Item
    (Order_ID, ISBN, Price_Sold, Last_updated, Is_Removed)
values (8, "9780316769174", 18, "2019-06-26 03:26:13", true);
insert into Order_Item
    (Order_ID, ISBN, Price_Sold, Last_updated, Is_Removed)
values (9, "9780439023481", 10, "2019-12-15 21:10:46", true);
insert into Order_Item
    (Order_ID, ISBN, Price_Sold, Last_updated, Is_Removed)
values (10, "9780307277671", 20, "2019-12-04 05:44:00", false);
insert into Order_Item
    (Order_ID, ISBN, Price_Sold, Last_updated, Is_Removed)
values (12, "9781594480003", 20, "2019-07-28 02:53:12", true);
insert into Order_Item
    (Order_ID, ISBN, Price_Sold, Last_updated, Is_Removed)
values (13, "9780140283334", 14, "2019-07-20 14:55:23", false);
insert into Order_Item
    (Order_ID, ISBN, Price_Sold, Last_updated, Is_Removed)
values (14, "9780679601685", 17, "2019-08-11 09:42:23", false);
insert into Order_Item
    (Order_ID, ISBN, Price_Sold, Last_updated, Is_Removed)
values (15, "9780062315007", 16, "2019-07-20 23:24:57", true);
insert into Order_Item
    (Order_ID, ISBN, Price_Sold, Last_updated, Is_Removed)
values (16, "9780770430078", 19, "2019-02-26 07:58:08", true);
insert into Order_Item
    (Order_ID, ISBN, Price_Sold, Last_updated, Is_Removed)
values (18, "9780375831003", 13, "2019-09-27 19:19:39", true);
insert into Order_Item
    (Order_ID, ISBN, Price_Sold, Last_updated, Is_Removed)
values (19, "9780307588371", 17, "2019-09-10 20:50:20", true);
insert into Order_Item
    (Order_ID, ISBN, Price_Sold, Last_updated, Is_Removed)
values (20, "9781416524793", 14, "2019-07-11 04:24:09", true);

INSERT INTO Book_Authors
VALUES (1, "9780142000670");
#Of Mice and Men
INSERT INTO Book_Authors
VALUES (2, "9780439244190");
#Holes
INSERT INTO Book_Authors
VALUES (3, "9780061120084");
#To Kill a Mockingbird
INSERT INTO Book_Authors
VALUES (4, "9780684830421");
#The Great Gatsby
INSERT INTO Book_Authors
VALUES (5, "9780606323451");
#HP and Sorceror Stone
INSERT INTO Book_Authors
VALUES (6, "9780451526342");
#Animal Farm
INSERT INTO Book_Authors
VALUES (7, "9780316769174");
#Catcher in the Rye
INSERT INTO Book_Authors
VALUES (56, "9780439023481");
#Hunger Games
INSERT INTO Book_Authors
VALUES (31, "9780307277671");
#Da Vinci Code
INSERT INTO Book_Authors
VALUES (8, "9781594480003");
#Kite Runner
INSERT INTO Book_Authors
VALUES (9, "9780140283334");
#Lord of the Flies
INSERT INTO Book_Authors
VALUES (10, "9780679601685");
#Pride and Prejudice
INSERT INTO Book_Authors
VALUES (11, "9780062315007");
#The Alchemist
INSERT INTO Book_Authors
VALUES (12, "9780770430078");
#Life of Pi
INSERT INTO Book_Authors
VALUES (13, "9780375831003");
#The Book Thief
INSERT INTO Book_Authors
VALUES (38, "9780307588371");
#Gone Girl
INSERT INTO Book_Authors
VALUES (31, "9781416524793");
#Angels & Demons
INSERT INTO Book_Authors
VALUES (14, "9780393970128");
#Dracula
INSERT INTO Book_Authors
VALUES (15, "9780141439471");
#Frankenstein
INSERT INTO Book_Authors
VALUES (16, "9780385603102");
#House of Leaves
INSERT INTO Book_Authors
VALUES (17, "9780143039983");
#The Haunting of Hill House
INSERT INTO Book_Authors
VALUES (28, "9780450040184");
#The Shining
INSERT INTO Book_Authors
VALUES (18, "9780061007224");
#The Exorcist
INSERT INTO Book_Authors
VALUES (28, "9781416524342");
#Pet Sematary
INSERT INTO Book_Authors
VALUES (28, "9780450411434");
#It
INSERT INTO Book_Authors
VALUES (53, "9780380729401");
#Something Wicked This Way Comes
INSERT INTO Book_Authors
VALUES (19, "9780345476876");
#Interview with the Vampire
INSERT INTO Book_Authors
VALUES (20, "9780735212510");
#The Hunger
INSERT INTO Book_Authors
VALUES (28, "9780450031069");
#Salem''s Lot
INSERT INTO Book_Authors
VALUES (21, "9780307346605");
#World War Z: An Oral History of the Zombie War
INSERT INTO Book_Authors
VALUES (22, "9780727860996");
#Hell House
INSERT INTO Book_Authors
VALUES (23, "9780062200570");
#NOS4A2
INSERT INTO Book_Authors
VALUES (24, "9780061139376");
#Coraline
INSERT INTO Book_Authors
VALUES (25, "9780671685638");
#Ghost Story
INSERT INTO Book_Authors
VALUES (26, "9780345504968");
#The Passage
INSERT INTO Book_Authors
VALUES (27, "9780062259660");
#Bird Box
INSERT INTO Book_Authors
VALUES (28, "9781982110567");
#The Institute
INSERT INTO Book_Authors
VALUES (29, "9780307949486");
#The Girl with the Dragon Tattoo
INSERT INTO Book_Authors
VALUES (30, "9780312330873");
#And Then There Were None
INSERT INTO Book_Authors
VALUES (32, "9780316323703");
#Rebecca
INSERT INTO Book_Authors
VALUES (33, "9780679745587");
#In Cold Blood
INSERT INTO Book_Authors
VALUES (34, "9780451205766");
#The Godfather
INSERT INTO Book_Authors
VALUES (35, "9780316166683");
#The Lovely Bones
INSERT INTO Book_Authors
VALUES (36, "9780156001311");
#The Name of the Rose
INSERT INTO Book_Authors
VALUES (37, "9780582418271");
#The Firm
INSERT INTO Book_Authors
VALUES (39, "9780380731862");
#Shutter Island
INSERT INTO Book_Authors
VALUES (39, "9780060584757");
#Mystic River
INSERT INTO Book_Authors
VALUES (40, "9780143034902");
#The Shadow of the Wind
INSERT INTO Book_Authors
VALUES (41, "9780812976144");
#The Alienist
INSERT INTO Book_Authors
VALUES (42, "9780394758282");
#The Big Sleep
INSERT INTO Book_Authors
VALUES (43, "9780312362089");
#One for the Money
INSERT INTO Book_Authors
VALUES (44, "9780752865331");
#The Maltese Falcon
INSERT INTO Book_Authors
VALUES (45, "9780525945567");
#Red Dragon
INSERT INTO Book_Authors
VALUES (46, "9780670038602");
#In the Woods
INSERT INTO Book_Authors
VALUES (47, "9780446350983");
#Presumed Innocent
INSERT INTO Book_Authors
VALUES (48, "9780743298025");
#The Thirteenth Tale
INSERT INTO Book_Authors
VALUES (49, "9780812550702");
#Ender''s Game
INSERT INTO Book_Authors
VALUES (50, "9780141036144");
#1984 (Sci-Fi)
INSERT INTO Book_Authors
VALUES (51, "9780307887436");
#Ready Player One
INSERT INTO Book_Authors
VALUES (52, "9780593099322");
#Dune
INSERT INTO Book_Authors
VALUES (53, "9781451673319");
#Farenheit 451 (Sci-Fi)
INSERT INTO Book_Authors
VALUES (54, "9780804139021");
#The Martian
INSERT INTO Book_Authors
VALUES (58, "9780553803716");
#Foundation
INSERT INTO Book_Authors
VALUES (56, "9780439023498");
#Catching Fire
INSERT INTO Book_Authors
VALUES (55, "9781524796976");
#Do Androids Dream of Electric Sheep?
INSERT INTO Book_Authors
VALUES (56, "9780439023511");
#Mockingjay
INSERT INTO Book_Authors
VALUES (57, "9780486284729");
#The Time Machine
INSERT INTO Book_Authors
VALUES (58, "9780553803709");
#I, Robot
INSERT INTO Book_Authors
VALUES (59, "9780062024039");
#Divergent
INSERT INTO Book_Authors
VALUES (60, "9780441788385");
#Stranger in a Strange Land
INSERT INTO Book_Authors
VALUES (61, "9780771008795");
#Handmaid''s Tale (Sci-Fi)
INSERT INTO Book_Authors
VALUES (62, "9781509808335");
#The Restaurant at the End of the Universe
INSERT INTO Book_Authors
VALUES (63, "9780345538987");
#Jurassic Park
INSERT INTO Book_Authors
VALUES (64, "9780451457998");
#2001: A Space Odyssey
INSERT INTO Book_Authors
VALUES (65, "9780989671767");
#Unsouled
INSERT INTO Book_Authors
VALUES (65, "9780989671774");
#Soulsmith
INSERT INTO Book_Authors
VALUES (65, "9780989671781");
#Blackflame
INSERT INTO Book_Authors
VALUES (65, "9780999851104");
#Skysworn
INSERT INTO Book_Authors
VALUES (65, "9780999851111");
#Ghostwater
INSERT INTO Book_Authors
VALUES (65, "9780999851128");
#Underlord
INSERT INTO Book_Authors
VALUES (65, "9780999851135");
#Uncrowned
INSERT INTO Book_Authors
VALUES (66, "9780316075558");
#The Black Prism
INSERT INTO Book_Authors
VALUES (66, "9780316079914");
#The Blinding Knife
INSERT INTO Book_Authors
VALUES (66, "9780316058964");
#The Broken Eye
INSERT INTO Book_Authors
VALUES (66, "9780316251334");
#The Blood Mirror
INSERT INTO Book_Authors
VALUES (66, "9780316251303");
#The Burning White
INSERT INTO Book_Authors
VALUES (67, "9780765311788");
#The Final Empire
INSERT INTO Book_Authors
VALUES (67, "9780765316882");
#The Well of Ascension
INSERT INTO Book_Authors
VALUES (67, "9780765316899");
#The Hero of Ages
INSERT INTO Book_Authors
VALUES (67, "9780765330420");
#The Alloy of Law
INSERT INTO Book_Authors
VALUES (67, "9780765378552");
#Shadows of Self
INSERT INTO Book_Authors
VALUES (67, "9781466862678");
#The Bands of Mourning
INSERT INTO Book_Authors
VALUES (68, "9780756404079");
#The Name of the Wind
INSERT INTO Book_Authors
VALUES (68, "9780756404734");
#The Wise Man''s Fear
INSERT INTO Book_Authors
VALUES (69, "9781937007294");
#Fated
INSERT INTO Book_Authors
VALUES (69, "9781937007591");
#Cursed
INSERT INTO Book_Authors
VALUES (69, "9781937007720");
#Taken
INSERT INTO Book_Authors
VALUES (69, "9780425264928");
#Chosen
INSERT INTO Book_Authors
VALUES (69, "9780425264942");
#Hidden
INSERT INTO Book_Authors
VALUES (69, "9780425275757");
#Veiled
INSERT INTO Book_Authors
VALUES (69, "9780698165083");
#Burned
INSERT INTO Book_Authors
VALUES (69, "9781101988527");
#Bound
INSERT INTO Book_Authors
VALUES (69, "9780356507217");
#Marked
INSERT INTO Book_Authors
VALUES (69, "9780440000587");
#Fallen

INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780142000670", "Of Mice and Men", "Fiction", 103,
        "The compelling story of two outsiders striving to find their place in an unforgiving world. Drifters in search of work, George and his simple-minded friend Lennie have nothing in the world except each other and a dream--a dream that one day they will have some land of their own. Eventually they find work on a ranch in California 2019s Salinas Valley, but their hopes are doomed as Lennie, struggling against extreme cruelty, misunderstanding and feelings of jealousy, becomes a victim of his own strength. Tackling universal themes such as the friendship of a shared vision, and giving voice to America 2019s lonely and dispossessed, Of Mice and Men has proved one of Steinbeck 2019s most popular works, achieving success as a novel, a Broadway play and three acclaimed films.",
        STR_TO_DATE("1/8/2002", "%m/%d/%Y"), 1, STR_TO_DATE("1/8/2017", "%m/%d/%Y"),
        STR_TO_DATE("2/8/2017", "%m/%d/%Y"), FALSE, 15, 12, 6);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780439244190", "Holes", "Fiction", 233,
        "Stanley tries to dig up the truth in this inventive and darkly humorous tale of crime and punishment 2014 and redemption. Stanley Yelnats is under a curse. A curse that began with his no-good-dirty-rotten- pig-stealing-great-great-grandfather and has since followed generations of Yelnats. Now Stanley has been unjustly sent to a boys detention center, Camp Green Lake, where the warden makes the boys \"build character\" by spending all day, every day, digging holes: five feet wide and five feet deep. It doesn\'t take long for Stanley to realize there\'s more than character improvement going on at Camp Green Lake. The boys are digging holes because the warden is looking for something. Stanley tries to dig up the truth in this inventive and darkly humorous tale of crime and punishment 2014and redemption.",
        STR_TO_DATE("9/2/2000", "%m/%d/%Y"), 2, STR_TO_DATE("9/2/2018", "%m/%d/%Y"),
        STR_TO_DATE("10/2/2018", "%m/%d/%Y"), TRUE, 19, 15, 5);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780061120084", "To Kill a Mockingbird", "Fiction", 324,
        "The unforgettable novel of a childhood in a sleepy Southern town and the crisis of conscience that rocked it, To Kill A Mockingbird became both an instant bestseller and a critical success when it was first published in 1960. It went on to win the Pulitzer Prize in 1961 and was later made into an Academy Award-winning film, also a classic.Compassionate, dramatic, and deeply moving, To Kill A Mockingbird takes readers to the roots of human behavior - to innocence and experience, kindness and cruelty, love and hatred, humor and pathos. Now with over 18 million copies in print and translated into forty languages, this regional story by a young Alabama woman claims universal appeal. Harper Lee always considered her book to be a simple love story. Today it is regarded as a masterpiece of American literature.",
        STR_TO_DATE("5/23/2006", "%m/%d/%Y"), 3, STR_TO_DATE("5/23/2019", "%m/%d/%Y"),
        STR_TO_DATE("5/23/2019", "%m/%d/%Y"), FALSE, 15, 12, 6);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780684830421", "The Great Gatsby", "Fiction", 200,
        "Alternate Cover Edition ISBN: 0743273567 (ISBN13: 9780743273565)The Great Gatsby, F. Scott Fitzgerald\'s third book, stands as the supreme achievement of his career. This exemplary novel of the Jazz Age has been acclaimed by generations of readers. The story is of the fabulously wealthy Jay Gatsby and his new love for the beautiful Daisy Buchanan, of lavish parties on Long Island at a time when The New York Times noted \"gin was the national drink and sex the national obsession,\" it is an exquisitely crafted tale of America in the 1920s.The Great Gatsby is one of the great classics of twentieth-century literature.(back cover)",
        STR_TO_DATE("9/4/2020", "%m/%d/%Y"), 1, STR_TO_DATE("9/4/2018", "%m/%d/%Y"),
        STR_TO_DATE("10/4/2018", "%m/%d/%Y"), FALSE, 16, 14, 8);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780606323451", "Harry Potter and the Sorcerer\'s Stone", "Fiction", 322,
        "Alternate cover edition of ISBN 9780439554930Harry Potter\'s life is miserable. His parents are dead and he\'s stuck with his heartless relatives, who force him to live in a tiny closet under the stairs. But his fortune changes when he receives a letter that tells him the truth about himself: he\'s a wizard. A mysterious visitor rescues him from his relatives and takes him to his new home, Hogwarts School of Witchcraft and Wizardry.After a lifetime of bottling up his magical powers, Harry finally feels like a normal kid. But even within the Wizarding community, he is special. He is the boy who lived: the only person to have ever survived a killing curse inflicted by the evil Lord Voldemort, who launched a brutal takeover of the Wizarding world, only to vanish after failing to kill Harry.Though Harry\'s first year at Hogwarts is the best of his life, not everything is perfect. There is a dangerous secret object hidden within the castle walls, and Harry believes it\'s his responsibility to prevent it from falling into evil hands. But doing so will bring him into contact with forces more terrifying than he ever could have imagined.Full of sympathetic characters, wildly imaginative situations, and countless exciting details, the first installment in the series assembles an unforgettable magical world and sets the stage for many high-stakes adventures to come.",
        STR_TO_DATE("6/26/1997", "%m/%d/%Y"), 1, STR_TO_DATE("6/26/2019", "%m/%d/%Y"),
        STR_TO_DATE("7/26/2019", "%m/%d/%Y"), FALSE, 16, 13, 6);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780451526342", "Animal Farm", "Fiction", 141,
        "Librarian\'s note: There is an Alternate Cover Edition for this edition of this book here.A farm is taken over by its overworked, mistreated animals. With flaming idealism and stirring slogans, they set out to create a paradise of progress, justice, and equality. Thus the stage is set for one of the most telling satiric fables ever penned  2013a razor-edged fairy tale for grown-ups that records the evolution from revolution against tyranny to a totalitarianism just as terrible. When Animal Farm was first published, Stalinist Russia was seen as its target. Today it is devastatingly clear that wherever and whenever freedom is attacked, under whatever banner, the cutting clarity and savage comedy of George Orwell 2019s masterpiece have a meaning and message still ferociously fresh.",
        STR_TO_DATE("4/1/1996", "%m/%d/%Y"), 4, STR_TO_DATE("4/1/2017", "%m/%d/%Y"),
        STR_TO_DATE("5/1/2017", "%m/%d/%Y"), FALSE, 15, 12, 7);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780316769174", "The Catcher in the Rye", "Fiction", 277,
        "The hero-narrator of The Catcher in the Rye is an ancient child of sixteen, a native New Yorker named Holden Caulfield. Through circumstances that tend to preclude adult, secondhand description, he leaves his prep school in Pennsylvania and goes underground in New York City for three days. The boy himself is at once too simple and too complex for us to make any final comment about him or his story. Perhaps the safest thing we can say about Holden is that he was born in the world not just strongly attracted to beauty but, almost, hopelessly impaled on it. There are many voices in this novel: children\'s voices, adult voices, underground voices-but Holden\'s voice is the most eloquent of all. Transcending his own vernacular, yet remaining marvelously faithful to it, he issues a perfectly articulated cry of mixed pain and pleasure. However, like most lovers and clowns and poets of the higher orders, he keeps most of the pain to, and for, himself. The pleasure he gives away, or sets aside, with all his heart. It is there for the reader who can handle it to keep. J.D. Salinger\'s classic novel of teenage angst and rebellion was first published in 1951. The novel was included on Time\'s 2005 list of the 100 best English-language novels written since 1923. It was named by Modern Library and its readers as one of the 100 best English-language novels of the 20th century. It has been frequently challenged in the court for its liberal use of profanity and portrayal of sexuality and in the 1950\'s and 60\'s it was the novel that every teenage boy wants to read.",
        STR_TO_DATE("1/30/2001", "%m/%d/%Y"), 1, STR_TO_DATE("1/30/2018", "%m/%d/%Y"),
        STR_TO_DATE("1/30/2018", "%m/%d/%Y"), FALSE, 15, 13, 5);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780439023481", "The Hunger Games", "Fiction", 374,
        "Could you survive on your own, in the wild, with everyone out to make sure you don''t live to see the morning?In the ruins of a place once known as North America lies the nation of Panem, a shining Capitol surrounded by twelve outlying districts. The Capitol is harsh and cruel and keeps the districts in line by forcing them all to send one boy and one girl between the ages of twelve and eighteen to participate in the annual Hunger Games, a fight to the death on live TV. Sixteen-year-old Katniss Everdeen, who lives alone with her mother and younger sister, regards it as a death sentence when she is forced to represent her district in the Games. But Katniss has been close to dead before - and survival, for her, is second nature. Without really meaning to, she becomes a contender. But if she is to win, she will have to start making choices that weigh survival against humanity and life against love.New York Times bestselling author Suzanne Collins delivers equal parts suspense and philosophy, adventure and romance, in this searing novel set in a future with unsettling parallels to our present.",
        STR_TO_DATE("9/14/2008", "%m/%d/%Y"), 14, STR_TO_DATE("9/14/2019", "%m/%d/%Y"),
        STR_TO_DATE("9/14/2019", "%m/%d/%Y"), FALSE, 19, 12, 10);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780307277671", "The Da Vinci Code", "Fiction", 489,
        "An ingenious code hidden in the works of Leonardo da Vinci.A desperate race through the cathedrals and castles of Europe.An astonishing truth concealed for centuries . . . unveiled at last.While in Paris, Harvard symbologist Robert Langdon is awakened by a phone call in the dead of the night. The elderly curator of the Louvre has been murdered inside the museum, his body covered in baffling symbols. As Langdon and gifted French cryptologist Sophie Neveu sort through the bizarre riddles, they are stunned to discover a trail of clues hidden in the works of Leonardo da Vinci 2014clues visible for all to see and yet ingeniously disguised by the painter.Even more startling, the late curator was involved in the Priory of Sion 2014a secret society whose members included Sir Isaac Newton, Victor Hugo, and Da Vinci 2014and he guarded a breathtaking historical secret. Unless Langdon and Neveu can decipher the labyrinthine puzzle 2014while avoiding the faceless adversary who shadows their every move 2014the explosive, ancient truth will be lost forever.",
        STR_TO_DATE("3/28/2006", "%m/%d/%Y"), 13, STR_TO_DATE("3/28/2017", "%m/%d/%Y"),
        STR_TO_DATE("3/28/2017", "%m/%d/%Y"), FALSE, 16, 13, 7);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9781594480003", "The Kite Runner", "Fiction", 371,
        "The unforgettable, heartbreaking story of the unlikely friendship between a wealthy boy and the son of his father 2019s servant, The Kite Runner is a beautifully crafted novel set in a country that is in the process of being destroyed. It is about the power of reading, the price of betrayal, and the possibility of redemption; and an exploration of the power of fathers over sons 2014their love, their sacrifices, their lies.A sweeping story of family, love, and friendship told against the devastating backdrop of the history of Afghanistan over the last thirty years, The Kite Runner is an unusual and powerful novel that has become a beloved, one-of-a-kind classic.--khaledhosseini.com",
        STR_TO_DATE("5/4/2020", "%m/%d/%Y"), 1, STR_TO_DATE("5/4/2019", "%m/%d/%Y"),
        STR_TO_DATE("5/4/2019", "%m/%d/%Y"), FALSE, 15, 13, 7);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780140283334", "Lord of the Flies", "Fiction", 182,
        "At the dawn of the next world war, a plane crashes on an uncharted island, stranding a group of schoolboys. At first, with no adult supervision, their freedom is something to celebrate; this far from civilization the boys can do anything they want. Anything. They attempt to forge their own society, failing, however, in the face of terror, sin and evil. And as order collapses, as strange howls echo in the night, as terror begins its reign, the hope of adventure seems as far from reality as the hope of being rescued. Labeled a parable, an allegory, a myth, a morality tale, a parody, a political treatise, even a vision of the apocalypse, Lord of the Flies is perhaps our most memorable novel about  201cthe end of innocence, the darkness of man 2019s heart. 201d",
        STR_TO_DATE("10/1/1999", "%m/%d/%Y"), 6, STR_TO_DATE("10/1/2017", "%m/%d/%Y"),
        STR_TO_DATE("11/1/2017", "%m/%d/%Y"), FALSE, 16, 11, 6);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780679601685", "Pride and Prejudice", "Fiction", 279,
        "Alternate cover edition of ISBN 9780679783268Since its immediate success in 1813, Pride and Prejudice has remained one of the most popular novels in the English language. Jane Austen called this brilliant work \"her own darling child\" and its vivacious heroine, Elizabeth Bennet, \"as delightful a creature as ever appeared in print.\" The romantic clash between the opinionated Elizabeth and her proud beau, Mr. Darcy, is a splendid performance of civilized sparring. And Jane Austen\'s radiant wit sparkles as her characters dance a delicate quadrille of flirtation and intrigue, making this book the most superb comedy of manners of Regency England.",
        STR_TO_DATE("10/10/2000", "%m/%d/%Y"), 1, STR_TO_DATE("10/10/2018", "%m/%d/%Y"),
        STR_TO_DATE("11/10/2018", "%m/%d/%Y"), FALSE, 17, 12, 9);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780062315007", "The Alchemist", "Fiction", 182,
        "Paulo Coelho\'s enchanting novel has inspired a devoted following around the world. This story, dazzling in its powerful simplicity and soul-stirring wisdom, is about an Andalusian shepherd boy named Santiago who travels from his homeland in Spain to the Egyptian desert in search of a treasure buried near the Pyramids. Along the way he meets a Gypsy woman, a man who calls himself king, and an alchemist, all of whom point Santiago in the direction of his quest. No one knows what the treasure is, or if Santiago will be able to surmount the obstacles in his path. But what starts out as a journey to find worldly goods turns into a discovery of the treasure found within. Lush, evocative, and deeply humane, the story of Santiago is an eternal testament to the transforming power of our dreams and the importance of listening to our hearts.Illustration: Jim Tierney",
        STR_TO_DATE("4/15/2014", "%m/%d/%Y"), 7, STR_TO_DATE("4/15/2019", "%m/%d/%Y"),
        STR_TO_DATE("4/15/2019", "%m/%d/%Y"), FALSE, 15, 11, 8);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780770430078", "Life of Pi", "Fiction", 460,
        "Life of Pi is a fantasy adventure novel by Yann Martel published in 2001. The protagonist, Piscine Molitor \"Pi\" Patel, a Tamil boy from Pondicherry, explores issues of spirituality and practicality from an early age. He survives 227 days after a shipwreck while stranded on a boat in the Pacific Ocean with a Bengal tiger named Richard Parker.",
        STR_TO_DATE("8/29/2006", "%m/%d/%Y"), 1, STR_TO_DATE("8/29/2017", "%m/%d/%Y"),
        STR_TO_DATE("8/29/2017", "%m/%d/%Y"), FALSE, 15, 15, 5);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780375831003", "The Book Thief", "Fiction", 552,
        "It is 1939. Nazi Germany. The country is holding its breath. Death has never been busier, and will be busier still.By her brother\'s graveside, Liesel\'s life is changed when she picks up a single object, partially hidden in the snow. It is The Gravedigger\'s Handbook, left behind there by accident, and it is her first act of book thievery. So begins a love affair with books and words, as Liesel, with the help of her accordian-playing foster father, learns to read. Soon she is stealing books from Nazi book-burnings, the mayor\'s wife\'s library, wherever there are books to be found.But these are dangerous times. When Liesel\'s foster family hides a Jew in their basement, Liesel\'s world is both opened up, and closed down.In superbly crafted writing that burns with intensity, award-winning author Markus Zusak has given us one of the most enduring stories of our time.",
        STR_TO_DATE("3/14/2006", "%m/%d/%Y"), 9, STR_TO_DATE("3/14/2019", "%m/%d/%Y"),
        STR_TO_DATE("4/14/2019", "%m/%d/%Y"), FALSE, 15, 14, 10);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780307588371", "Gone Girl", "Fiction", 415,
        "Marriage can be a real killer.On a warm summer morning in North Carthage, Missouri, it is Nick and Amy Dunne 2019s fifth wedding anniversary. Presents are being wrapped and reservations are being made when Nick 2019s clever and beautiful wife disappears from their rented McMansion on the Mississippi River. Husband-of-the-Year Nick isn 2019t doing himself any favors with cringe-worthy daydreams about the slope and shape of his wife 2019s head, but passages from Amy\'s diary reveal the alpha-girl perfectionist could have put anyone dangerously on edge. Under mounting pressure from the police and the media 2014as well as Amy 2019s fiercely doting parents 2014the town golden boy parades an endless series of lies, deceits, and inappropriate behavior. Nick is oddly evasive, and he 2019s definitely bitter 2014but is he really a killer?As the cops close in, every couple in town is soon wondering how well they know the one that they love. With his twin sister, Margo, at his side, Nick stands by his innocence. Trouble is, if Nick didn 2019t do it, where is that beautiful wife? And what was in that silvery gift box hidden in the back of her bedroom closet?With her razor-sharp writing and trademark psychological insight, Gillian Flynn delivers a fast-paced, devilishly dark, and ingeniously plotted thriller that confirms her status as one of the hottest writers around.One of the most critically acclaimed suspense writers of our time, New York Times bestseller Gillian Flynn takes that statement to its darkest place in this unputdownable masterpiece about a marriage gone terribly, terribly wrong. The Chicago Tribune proclaimed that her work  201cdraws you in and keeps you reading with the force of a pure but nasty addiction. 201d Gone Girl 2019s toxic mix of sharp-edged wit and deliciously chilling prose creates a nerve-fraying thriller that confounds you at every turn.Source: gillian-flynn.com",
        STR_TO_DATE("4/22/2014", "%m/%d/%Y"), 1, STR_TO_DATE("4/22/2017", "%m/%d/%Y"),
        STR_TO_DATE("5/22/2017", "%m/%d/%Y"), FALSE, 16, 10, 5);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9781416524793", "Angels & Demons", "Fiction", 736,
        "World-renowned Harvard symbologist Robert Langdon is summoned to a Swiss research facility to analyze a cryptic symbol seared into the chest of a murdered physicist. What he discovers is unimaginable: a deadly vendetta against the Catholic Church by a centuries-old underground organization -- the Illuminati. In a desperate race to save the Vatican from a powerful time bomb, Langdon joins forces in Rome with the beautiful and mysterious scientist Vittoria Vetra. Together they embark on a frantic hunt through sealed crypts, dangerous catacombs, and deserted cathedrals, and into the depths of the most secretive vault on earth...the long-forgotten Illuminati lair.(back cover)",
        STR_TO_DATE("4/1/2006", "%m/%d/%Y"), 1, STR_TO_DATE("4/1/2018", "%m/%d/%Y"),
        STR_TO_DATE("4/1/2018", "%m/%d/%Y"), FALSE, 19, 11, 9);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780393970128", "Dracula", "Horror", 488,
        "You can find an alternative cover edition for this ISBN here and here.A rich selection of background and source materials is provided in three areas: Contexts includes probable inspirations for Dracula in the earlier works of James Malcolm Rymer and Emily Gerard. Also included are a discussion of Stoker\'s working notes for the novel and Draculas Guest, the original opening chapter to Dracula. Reviews and Reactions reprints five early reviews of the novel. Dramatic and Film Variations focuses on theater and film adaptations of Dracula, two indications of the novel\'s unwavering appeal. David J. Skal, Gregory A. Waller, and Nina Auerbach offer their varied perspectives. Checklists of both dramatic and film adaptations are included.Criticism collects seven theoretical interpretations of Dracula by Phyllis A. Roth, Carol A. Senf, Franco Moretti, Christopher Craft, Bram Dijkstra, Stephen D. Arata, and Talia Schaffer.A Chronology and a Selected Bibliography are included.",
        STR_TO_DATE("5/12/1986", "%m/%d/%Y"), 10, STR_TO_DATE("5/12/2019", "%m/%d/%Y"),
        STR_TO_DATE("5/12/2019", "%m/%d/%Y"), FALSE, 19, 11, 5);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780141439471", "Frankenstein", "Horror", 335,
        "Mary Shelley began writing Frankenstein when she was only eighteen. At once a Gothic thriller, a passionate romance, and a cautionary tale about the dangers of science, Frankenstein tells the story of committed science student Victor Frankenstein. Obsessed with discovering the cause of generation and life and bestowing animation upon lifeless matter, Frankenstein assembles a human being from stolen body parts but; upon bringing it to life, he recoils in horror at the creature\'s hideousness. Tormented by isolation and loneliness, the once-innocent creature turns to evil and unleashes a campaign of murderous revenge against his creator, Frankenstein.Frankenstein, an instant bestseller and an important ancestor of both the horror and science fiction genres, not only tells a terrifying story, but also raises profound, disturbing questions about the very nature of life and the place of humankind within the cosmos: What does it mean to be human? What responsibilities do we have to each other? How far can we go in tampering with Nature? In our age, filled with news of organ donation genetic engineering, and bio-terrorism, these questions are more relevant than ever.",
        STR_TO_DATE("6/25/2005", "%m/%d/%Y"), 1, STR_TO_DATE("6/25/2017", "%m/%d/%Y"),
        STR_TO_DATE("7/25/2017", "%m/%d/%Y"), FALSE, 17, 15, 9);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780385603102", "House of Leaves", "Horror", 705,
        "Years ago, when House of Leaves was first being passed around, it was nothing more than a badly bundled heap of paper, parts of which would occasionally surface on the Internet. No one could have anticipated the small but devoted following this terrifying story would soon command. Starting with an odd assortment of marginalized youth 2014musicians, tattoo artists, programmers, strippers, environmentalists, and adrenaline junkies 2014the book eventually made its way into the hands of older generations, who not only found themselves in those strangely arranged pages but also discovered a way back into the lives of their estranged children.Now, for the first time, this astonishing novel is made available in book form, complete with the original colored words, vertical footnotes, and newly added second and third appendices.The story remains unchanged, focusing on a young family that moves into a small home on Ash Tree Lane where they discover something is terribly wrong: their house is bigger on the inside than it is on the outside.Of course, neither Pulitzer Prize-winning photojournalist Will Navidson nor his companion Karen Green was prepared to face the consequences of that impossibility, until the day their two little children wandered off and their voices eerily began to return another story 2014of creature darkness, of an ever-growing abyss behind a closet door, and of that unholy growl which soon enough would tear through their walls and consume all their dreams.",
        STR_TO_DATE("3/7/2000", "%m/%d/%Y"), 1, STR_TO_DATE("3/7/2018", "%m/%d/%Y"),
        STR_TO_DATE("4/7/2018", "%m/%d/%Y"), TRUE, 15, 14, 7);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780143039983", "The Haunting of Hill House", "Horror", 182,
        "First published in 1959, Shirley Jackson\'s The Haunting of Hill House has been hailed as a perfect work of unnerving terror. It is the story of four seekers who arrive at a notoriously unfriendly pile called Hill House: Dr. Montague, an occult scholar looking for solid evidence of a \"haunting\"; Theodora, the lighthearted assistant; Eleanor, a friendless, fragile young woman well acquainted with poltergeists; and Luke, the future heir of Hill House. At first, their stay seems destined to be merely a spooky encounter with inexplicable phenomena. But Hill House is gathering its powers 2014and soon it will choose one of them to make its own.",
        STR_TO_DATE("11/28/2006", "%m/%d/%Y"), 1, STR_TO_DATE("11/28/2019", "%m/%d/%Y"),
        STR_TO_DATE("12/28/2019", "%m/%d/%Y"), FALSE, 15, 13, 6);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780450040184", "The Shining", "Horror", 659,
        "Jack Torrance\'s new job at the Overlook Hotel is the perfect chance for a fresh start. As the off-season caretaker at the atmospheric old hotel, he''ll have plenty of time to spend reconnecting with his family and working on his writing. But as the harsh winter weather sets in, the idyllic location feels ever more remote...and more sinister. And the only one to notice the strange and terrible forces gathering around the Overlook is Danny Torrance, a uniquely gifted five-year-old.",
        STR_TO_DATE("7/1/1980", "%m/%d/%Y"), 1, STR_TO_DATE("7/1/2017", "%m/%d/%Y"),
        STR_TO_DATE("8/1/2017", "%m/%d/%Y"), FALSE, 16, 12, 9);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780061007224", "The Exorcist", "Horror", 385,
        "Originally published in 1971, The Exorcist is now a major television series on FOX. It remains one of the most controversial novels ever written and went on to become a literary phenomenon: It spent fifty-seven weeks on the New York Times bestseller list, seventeen consecutively at number one. Inspired by a true story of a child 2019s demonic possession in the 1940s, William Peter Blatty created an iconic novel that focuses on Regan, the eleven-year-old daughter of a movie actress residing in Washington, D.C. A small group of overwhelmed yet determined individuals must rescue Regan from her unspeakable fate, and the drama that ensues is gripping and unfailingly terrifying.Two years after its publication, The Exorcist was, of course, turned into a wildly popular motion picture, garnering ten Academy Award nominations. On opening day of the film, lines of the novel 2019s fans stretched around city blocks. In Chicago, frustrated moviegoers used a battering ram to gain entry through the double side doors of a theater. In Kansas City, police used tear gas to disperse an impatient crowd who tried to force their way into a cinema. The three major television networks carried footage of these events; CBS 2019s Walter Cronkite devoted almost ten minutes to the story. The Exorcist was, and is, more than just a novel and a film: it is a true landmark.Purposefully raw and profane, The Exorcist still has the extraordinary ability to disturb readers and cause them to forget that it is  201cjust a story. 201d Published here in this beautiful fortieth anniversary edition, it remains an unforgettable reading experience and will continue to shock and frighten a new generation of readers.",
        STR_TO_DATE("2/1/1994", "%m/%d/%Y"), 1, STR_TO_DATE("2/1/2018", "%m/%d/%Y"),
        STR_TO_DATE("3/1/2018", "%m/%d/%Y"), FALSE, 15, 14, 10);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9781416524342", "Pet Sematary", "Horror", 576,
        "The road in front of Dr. Louis Creed\'s rural Maine home frequently claims the lives of neighborhood pets. Louis has recently moved from Chicago to Ludlow with his wife Rachel, their children and pet cat. Near their house, local children have created a cemetery for the dogs and cats killed by the steady stream of transports on the busy highway. Deeper in the woods lies another graveyard, an ancient Indian burial ground whose sinister properties Louis discovers when the family cat is killed.source: stephenking.com",
        STR_TO_DATE("11/1/2005", "%m/%d/%Y"), 1, STR_TO_DATE("11/1/2019", "%m/%d/%Y"),
        STR_TO_DATE("12/1/2019", "%m/%d/%Y"), FALSE, 18, 11, 8);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780450411434", "It", "Horror", 1116,
        "Welcome to Derry, Maine ...It 2019s a small city, a place as hauntingly familiar as your own hometown. Only in Derry the haunting is real ...They were seven teenagers when they first stumbled upon the horror. Now they are grown-up men and women who have gone out into the big world to gain success and happiness. But none of them can withstand the force that has drawn them back to Derry to face the nightmare without an end, and the evil without a name.",
        STR_TO_DATE("10/1/1987", "%m/%d/%Y"), 1, STR_TO_DATE("10/1/2017", "%m/%d/%Y"),
        STR_TO_DATE("10/1/2017", "%m/%d/%Y"), FALSE, 19, 12, 5);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780380729401", "Something Wicked This Way Comes", "Horror", 293,
        "One of Ray Bradbury 2019s best-known and most popular novels, Something Wicked This Way Comes, now featuring a new introduction and material about its longstanding influence on culture and genre.For those who still dream and remember, for those yet to experience the hypnotic power of its dark poetry, step inside. The show is about to begin. Cooger & Dark 2019s Pandemonium Shadow Show has come to Green Town, Illinois, to destroy every life touched by its strange and sinister mystery. The carnival rolls in sometime after midnight, ushering in Halloween a week early. A calliope 2019s shrill siren song beckons to all with a seductive promise of dreams and youth regained. Two boys will discover the secret of its smoke, mazes, and mirrors; two friends who will soon know all too well the heavy cost of wishes 2026and the stuff of nightmares.Few novels have endured in the heart and memory as has Ray Bradbury 2019s unparalleled literary masterpiece Something Wicked This Way Comes. Scary and suspenseful, it is a timeless classic in the American canon.",
        STR_TO_DATE("3/1/1998", "%m/%d/%Y"), 11, STR_TO_DATE("3/1/2018", "%m/%d/%Y"),
        STR_TO_DATE("3/1/2018", "%m/%d/%Y"), FALSE, 15, 11, 6);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780345476876", "Interview with the Vampire", "Horror", 342,
        "This is the story of Louis, as told in his own words, of his journey through mortal and immortal life. Louis recounts how he became a vampire at the hands of the radiant and sinister Lestat and how he became indoctrinated, unwillingly, into the vampire way of life. His story ebbs and flows through the streets of New Orleans, defining crucial moments such as his discovery of the exquisite lost young child Claudia, wanting not to hurt but to comfort her with the last breaths of humanity he has inside. Yet, he makes Claudia a vampire, trapping her womanly passion, will, and intelligence inside the body of a small child. Louis and Claudia form a seemingly unbreakable alliance and even settle down for a while in the opulent French Quarter. Louis remembers Claudia\'s struggle to understand herself and the hatred they both have for Lestat that sends them halfway across the world to seek others of their kind. Louis and Claudia are desperate to find somewhere they belong, to find others who understand, and someone who knows what and why they are.Louis and Claudia travel Europe, eventually coming to Paris and the ragingly successful Theatre des Vampires--a theatre of vampires pretending to be mortals pretending to be vampires. Here they meet the magnetic and ethereal Armand, who brings them into a whole society of vampires. But Louis and Claudia find that finding others like themselves provides no easy answers and in fact presents dangers they scarcely imagined.Originally begun as a short story, the book took off as Anne wrote it, spinning the tragic and triumphant life experiences of a soul. As well as the struggles of its characters, Interview captures the political and social changes of two continents. The novel also introduces Lestat, Anne\'s most enduring character, a heady mixture of attraction and revulsion. The book, full of lush description, centers on the themes of immortality, change, loss, sexuality, and power.source: annerice.com",
        STR_TO_DATE("8/31/2004", "%m/%d/%Y"), 1, STR_TO_DATE("8/31/2019", "%m/%d/%Y"),
        STR_TO_DATE("9/20/2019", "%m/%d/%Y"), FALSE, 19, 14, 5);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780735212510", "The Hunger", "Horror", 376,
        "Evil is invisible, and it is everywhere. Tamsen Donner must be a witch. That is the only way to explain the series of misfortunes that have plagued the wagon train known as the Donner Party. Depleted rations, bitter quarrels, and the mysterious death of a little boy have driven the pioneers to the brink of madness. They cannot escape the feeling that someone--or something--is stalking them. Whether it was a curse from the beautiful Tamsen, the choice to follow a disastrous experimental route West, or just plain bad luck--the 90 men, women, and children of the Donner Party are at the brink of one of the deadliest and most disastrous western adventures in American history. While the ill-fated group struggles to survive in the treacherous mountain conditions--searing heat that turns the sand into bubbling stew; snows that freeze the oxen where they stand--evil begins to grow around them, and within them. As members of the party begin to disappear, they must ask themselves, What if there is something waiting in the mountains? Something disturbing and diseased...and very hungry?",
        STR_TO_DATE("3/6/2018", "%m/%d/%Y"), 12, STR_TO_DATE("3/6/2018", "%m/%d/%Y"),
        STR_TO_DATE("3/6/2018", "%m/%d/%Y"), TRUE, 17, 13, 6);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780450031069", "Salem''s Lot", "Horror", 483,
        "Thousands of miles away from the small township of salem''s Lot, two terrified people, a man and a boy, still share the secrets of those clapboard houses and tree-lined streets. They must return to salem''s Lot for a final confrontation with the unspeakable evil that lives on in the town.",
        STR_TO_DATE("6/13/2005", "%m/%d/%Y"), 1, STR_TO_DATE("6/13/2019", "%m/%d/%Y"),
        STR_TO_DATE("6/13/2019", "%m/%d/%Y"), FALSE, 15, 12, 6);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780307346605", "World War Z: An Oral History of the Zombie War", "Horror", 342,
        "The Zombie War came unthinkably close to eradicating humanity. Max Brooks, driven by the urgency of preserving the acid-etched first-hand experiences of the survivors from those apocalyptic years, traveled across the United States of America and throughout the world, from decimated cities that once teemed with upwards of thirty million souls to the most remote and inhospitable areas of the planet. He recorded the testimony of men, women, and sometimes children who came face-to-face with the living, or at least the undead, hell of that dreadful time. World War Z is the result. Never before have we had access to a document that so powerfully conveys the depth of fear and horror, and also the ineradicable spirit of resistance, that gripped human society through the plague years.Ranging from the now infamous village of New Dachang in the United Federation of China, where the epidemiological trail began with the twelve-year-old Patient Zero, to the unnamed northern forests where untold numbers sought a terrible and temporary refuge in the cold, to the United States of Southern Africa, where the Redeker Plan provided hope for humanity at an unspeakable price, to the west-of-the-Rockies redoubt where the North American tide finally started to turn, this invaluable chronicle reflects the full scope and duration of the Zombie War.Most of all, the book captures with haunting immediacy the human dimension of this epochal event. Facing the often raw and vivid nature of these personal accounts requires a degree of courage on the part of the reader, but the effort is invaluable because, as Mr. Brooks says in his introduction, \"By excluding the human factor, aren''t we risking the kind of personal detachment from history that may, heaven forbid, lead us one day to repeat it? And in the end, isn''t the human factor the only true difference between us and the enemy we now refer to as ''the living dead''?\"Note: Some of the numerical and factual material contained in this edition was previously published under the auspices of the United Nations Postwar Commission.",
        STR_TO_DATE("9/12/2006", "%m/%d/%Y"), 1, STR_TO_DATE("9/12/2017", "%m/%d/%Y"),
        STR_TO_DATE("10/12/2017", "%m/%d/%Y"), FALSE, 20, 13, 10);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780727860996", "Hell House", "Horror", 301,
        "Can any soul survive?Regarded as the Mount Everest of haunted houses, Belasco House has witnessed scenes of almost unimaginable horror and depravity. Two previous expeditions to investigate its secrets met with disaster, the participants destroyed by murder, suicide or insanity. Now a new investigation has been mounted - four strangers, each with his or her own reason for daring the unknown torments and temptations of the mansion...",
        STR_TO_DATE("7/1/2004", "%m/%d/%Y"), 1, STR_TO_DATE("7/1/2018", "%m/%d/%Y"),
        STR_TO_DATE("8/1/2018", "%m/%d/%Y"), FALSE, 15, 10, 7);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780062200570", "NOS4A2", "Horror", 692,
        "NOS4A2 is a spine-tingling novel of supernatural suspense from master of horror Joe Hill, the New York Times bestselling author of Heart-Shaped Box and Horns.Victoria McQueen has a secret gift for finding things: a misplaced bracelet, a missing photograph, answers to unanswerable questions. On her Raleigh Tuff Burner bike, she makes her way to a rickety covered bridge that, within moments, takes her wherever she needs to go, whether it 2019s across Massachusetts or across the country.Charles Talent Manx has a way with children. He likes to take them for rides in his 1938 Rolls-Royce Wraith with the NOS4A2 vanity plate. With his old car, he can slip right out of the everyday world, and onto the hidden roads that transport them to an astonishing  2013 and terrifying  2013 playground of amusements he calls  201cChristmasland. 201d Then, one day, Vic goes looking for trouble 2014and finds Manx. That was a lifetime ago. Now Vic, the only kid to ever escape Manx 2019s unmitigated evil, is all grown up and desperate to forget. But Charlie Manx never stopped thinking about Victoria McQueen. He 2019s on the road again and he 2019s picked up a new passenger: Vic 2019s own son.",
        STR_TO_DATE("4/30/2013", "%m/%d/%Y"), 15, STR_TO_DATE("4/30/2019", "%m/%d/%Y"),
        STR_TO_DATE("4/30/2019", "%m/%d/%Y"), FALSE, 19, 13, 10);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780061139376", "Coraline", "Horror", 162,
        "The day after they moved in, Coraline went exploring....In Coraline\'s family\'s new flat are twenty-one windows and fourteen doors. Thirteen of the doors open and close. The fourteenth is locked, and on the other side is only a brick wall, until the day Coraline unlocks the door to find a passage to another flat in another house just like her own. Only it\'s different. At first, things seem marvelous in the other flat. The food is better. The toy box is filled with wind-up angels that flutter around the bedroom, books whose pictures writhe and crawl and shimmer, little dinosaur skulls that chatter their teeth. But there\'s another mother, and another father, and they want Coraline to stay with them and be their little girl. They want to change her and never let her go. Other children are trapped there as well, lost souls behind the mirrors. Coraline is their only hope of rescue. She will have to fight with all her wits and all the tools she can find if she is to save the lost children, her ordinary life, and herself. Critically acclaimed and award-winning author Neil Gaiman will delight readers with his first novel for all ages.",
        STR_TO_DATE("8/29/2006", "%m/%d/%Y"), 1, STR_TO_DATE("8/29/2017", "%m/%d/%Y"),
        STR_TO_DATE("8/29/2017", "%m/%d/%Y"), FALSE, 20, 11, 6);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780671685638", "Ghost Story", "Horror", 567,
        "In life, not every sin goes unpunished.GHOST STORYFor four aging men in the terror-stricken town of Milburn, New York, an act inadvertently carried out in their youth has come back to haunt them. Now they are about to learn what happens to those who believe they can bury the past -- and get away with murder.",
        STR_TO_DATE("9/1/1989", "%m/%d/%Y"), 1, STR_TO_DATE("9/1/2018", "%m/%d/%Y"),
        STR_TO_DATE("10/1/2018", "%m/%d/%Y"), FALSE, 19, 12, 10);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780345504968", "The Passage", "Horror", 766,
        "IT HAPPENED FAST.THIRTY-TWO MINUTES FOR ONE WORLD TO DIE, ANOTHER TO BE BORN.First, the unthinkable: a security breach at a secret U.S. government facility unleashes the monstrous product of a chilling military experiment. Then, the unspeakable: a night of chaos and carnage gives way to sunrise on a nation, and ultimately a world, forever altered. All that remains for the stunned survivors is the long fight ahead and a future ruled by fear--of darkness, of death, of a fate far worse.As civilization swiftly crumbles into a primal landscape of predators and prey, two people flee in search of sanctuary. FBI agent Brad Wolgast is a good man haunted by what he\'s done in the line of duty. Six-year-old orphan Amy Harper Bellafonte is a refugee from the doomed scientific project that has triggered apocalypse. Wolgast is determined to protect her from the horror set loose by her captors, but for Amy, escaping the bloody fallout is only the beginning of a much longer odyssey--spanning miles and decades--toward the time an place where she must finish what should never have begun.With The Passage, award-winning author Justin Cronin has written both a relentlessly suspenseful adventure and an epic chronicle of human endurance in the face of unprecedented catastrophe and unimaginable danger. Its inventive storytelling, masterly prose, and depth of human insight mark it as a crucial and transcendent work of modern fiction.(front flap)",
        STR_TO_DATE("6/8/2010", "%m/%d/%Y"), 19, STR_TO_DATE("6/8/2019", "%m/%d/%Y"),
        STR_TO_DATE("6/8/2019", "%m/%d/%Y"), FALSE, 16, 12, 10);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780062259660", "Bird Box", "Horror", 262,
        "Written with the narrative tension of The Road and the exquisite terror of classic Stephen King, Bird Box is a propulsive, edge-of-your-seat horror thriller, set in an apocalyptic near-future world 2014a masterpiece of suspense from the brilliantly imaginative Josh Malerman.Something is out there . . . Something terrifying that must not be seen. One glimpse and a person is driven to deadly violence. No one knows what it is or where it came from.Five years after it began, a handful of scattered survivors remain, including Malorie and her two young children. Living in an abandoned house near the river, she has dreamed of fleeing to a place where they might be safe. Now, that the boy and girl are four, it is time to go. But the journey ahead will be terrifying: twenty miles downriver in a rowboat 2014blindfolded 2014with nothing to rely on but her wits and the children 2019s trained ears. One wrong choice and they will die. And something is following them. But is it man, animal, or monster?Engulfed in darkness, surrounded by sounds both familiar and frightening, Malorie embarks on a harrowing odyssey 2014a trip that takes her into an unseen world and back into the past, to the companions who once saved her. Under the guidance of the stalwart Tom, a motely group of strangers banded together against the unseen terror, creating order from the chaos. But when supplies ran low, they were forced to venture outside 2014and confront the ultimate question: in a world gone mad, who can really be trusted?Interweaving past and present, Josh Malerman 2019s breathtaking debut is a horrific and gripping snapshot of a world unraveled that will have you racing to the final page.",
        STR_TO_DATE("2/10/2015", "%m/%d/%Y"), 1, STR_TO_DATE("2/10/2017", "%m/%d/%Y"),
        STR_TO_DATE("3/10/2017", "%m/%d/%Y"), FALSE, 15, 15, 9);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9781982110567", "The Institute", "Horror", 576,
        "In the middle of the night, in a house on a quiet street in suburban Minneapolis, intruders silently murder Luke Ellis 2019s parents and load him into a black SUV. The operation takes less than two minutes. Luke will wake up at The Institute, in a room that looks just like his own, except there 2019s no window. And outside his door are other doors, behind which are other kids with special talents 2014telekinesis and telepathy 2014who got to this place the same way Luke did: Kalisha, Nick, George, Iris, and ten-year-old Avery Dixon. They are all in Front Half. Others, Luke learns, graduated to Back Half,  201clike the roach motel, 201d Kalisha says.  201cYou check in, but you don 2019t check out. 201dIn this most sinister of institutions, the director, Mrs. Sigsby, and her staff are ruthlessly dedicated to extracting from these children the force of their extranormal gifts. There are no scruples here. If you go along, you get tokens for the vending machines. If you don 2019t, punishment is brutal. As each new victim disappears to Back Half, Luke becomes more and more desperate to get out and get help. But no one has ever escaped from the Institute.As psychically terrifying as Firestarter, and with the spectacular kid power of It, The Institute is Stephen King 2019s gut-wrenchingly dramatic story of good vs. evil in a world where the good guys don 2019t always win.",
        STR_TO_DATE("9/10/2019", "%m/%d/%Y"), 20, STR_TO_DATE("9/10/2019", "%m/%d/%Y"),
        STR_TO_DATE("9/10/2019", "%m/%d/%Y"), FALSE, 15, 15, 9);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780307949486", "The Girl with the Dragon Tattoo", "Mystery", 465,
        "Harriet Vanger, a scion of one of Sweden 2019s wealthiest families disappeared over forty years ago. All these years later, her aged uncle continues to seek the truth. He hires Mikael Blomkvist, a crusading journalist recently trapped by a libel conviction, to investigate. He is aided by the pierced and tattooed punk prodigy Lisbeth Salander. Together they tap into a vein of unfathomable iniquity and astonishing corruption.An international publishing sensation, Stieg Larsson 2019s The Girl with the Dragon Tattoo combines murder mystery, family saga, love story, and financial intrigue into one satisfyingly complex and entertainingly atmospheric novel.Alternate Cover Edition ISBN 0307269752 (ISBN13: 9780307269751)",
        STR_TO_DATE("9/16/2008", "%m/%d/%Y"), 1, STR_TO_DATE("9/16/2017", "%m/%d/%Y"),
        STR_TO_DATE("10/16/2017", "%m/%d/%Y"), FALSE, 18, 11, 5);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780312330873", "And Then There Were None", "Mystery", 264,
        "First, there were ten 2014a curious assortment of strangers summoned as weekend guests to a little private island off the coast of Devon. Their host, an eccentric millionaire unknown to all of them, is nowhere to be found. All that the guests have in common is a wicked past they\'re unwilling to reveal 2014and a secret that will seal their fate. For each has been marked for murder. A famous nursery rhyme is framed and hung in every room of the mansion: Ten little boys went out to dine; One choked his little self and then there were nine. Nine little boys sat up very late; One overslept himself and then there were eight. Eight little boys traveling in Devon; One said he''d stay there then there were seven. Seven little boys chopping up sticks; One chopped himself in half and then there were six. Six little boys playing with a hive; A bumblebee stung one and then there were five. Five little boys going in for law; One got in Chancery and then there were four. Four little boys going out to sea; A red herring swallowed one and then there were three. Three little boys walking in the zoo; A big bear hugged one and then there were two. Two little boys sitting in the sun; One got frizzled up and then there was one. One little boy left all alone; He went out and hanged himself and then there were none. When they realize that murders are occurring as described in the rhyme, terror mounts. One by one they fall prey. Before the weekend is out, there will be none. Who has choreographed this dastardly scheme? And who will be left to tell the tale? Only the dead are above suspicion.",
        STR_TO_DATE("5/3/2004", "%m/%d/%Y"), 1, STR_TO_DATE("5/3/2018", "%m/%d/%Y"),
        STR_TO_DATE("5/3/2019", "%m/%d/%Y"), FALSE, 16, 11, 9);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780316323703", "Rebecca", "Mystery", 449,
        "Last night I dreamt I went to Manderley again . . .The novel begins in Monte Carlo, where our heroine is swept off her feet by the dashing widower Maxim de Winter and his sudden proposal of marriage. Orphaned and working as a lady\'s maid, she can barely believe her luck. It is only when they arrive at his massive country estate that she realizes how large a shadow his late wife will cast over their lives--presenting her with a lingering evil that threatens to destroy their marriage from beyond the grave.",
        STR_TO_DATE("12/17/2013", "%m/%d/%Y"), 1, STR_TO_DATE("12/17/2017", "%m/%d/%Y"),
        STR_TO_DATE("12/17/2019", "%m/%d/%Y"), TRUE, 18, 12, 8);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780679745587", "In Cold Blood", "Mystery", 343,
        "On November 15, 1959, in the small town of Holcomb, Kansas, four members of the Clutter family were savagely murdered by blasts from a shotgun held a few inches from their faces. There was no apparent motive for the crime, and there were almost no clues. As Truman Capote reconstructs the murder and the investigation that led to the capture, trial, and execution of the killers, he generates both mesmerizing suspense and astonishing empathy. At the center of his study are the amoral young killers Perry Smith and Dick Hickcock, who, vividly drawn by Capote, are shown to be reprehensible yet entirely and frighteningly human. In Cold Blood is a seminal work of modern prose, a remarkable synthesis of journalistic skill and powerfully evocative narrative.",
        STR_TO_DATE("6/16/2005", "%m/%d/%Y"), 1, STR_TO_DATE("6/16/2018", "%m/%d/%Y"),
        STR_TO_DATE("6/16/2019", "%m/%d/%Y"), FALSE, 16, 13, 10);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780451205766", "The Godfather", "Mystery", 448,
        "The Godfather 2014the epic tale of crime and betrayal that became a global phenomenon.Almost fifty years ago, a classic was born. A searing portrayal of the Mafia underworld, The Godfather introduced readers to the first family of American crime fiction, the Corleones, and their powerful legacy of tradition, blood, and honor. The seduction of power, the pitfalls of greed, and the allegiance to family 2014these are the themes that have resonated with millions of readers around the world and made The Godfather the definitive novel of the violent subculture that, steeped in intrigue and controversy, remains indelibly etched in our collective consciousness.~penguin.com",
        STR_TO_DATE("3/1/2002", "%m/%d/%Y"), 1, STR_TO_DATE("3/1/2019", "%m/%d/%Y"),
        STR_TO_DATE("3/1/2019", "%m/%d/%Y"), FALSE, 15, 11, 8);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780316166683", "The Lovely Bones", "Mystery", 372,
        "The Lovely Bones is the story of a family devastated by a gruesome murder -- a murder recounted by the teenage victim. Upsetting, you say? Remarkably, first-time novelist Alice Sebold takes this difficult material and delivers a compelling and accomplished exploration of a fractured family\'s need for peace and closure.The details of the crime are laid out in the first few pages: from her vantage point in heaven, Susie Salmon describes how she was confronted by the murderer one December afternoon on her way home from school. Lured into an underground hiding place, she was raped and killed. But what the reader knows, her family does not. Anxiously, we keep vigil with Susie, aching for her grieving family, desperate for the killer to be found and punished.Sebold creates a heaven that\'s calm and comforting, a place whose residents can have whatever they enjoyed when they were alive -- and then some. But Susie isn''t ready to release her hold on life just yet, and she intensely watches her family and friends as they struggle to cope with a reality in which she is no longer a part. To her great credit, Sebold has shaped one of the most loving and sympathetic fathers in contemporary literature.",
        STR_TO_DATE("9/1/2006", "%m/%d/%Y"), 16, STR_TO_DATE("9/1/2017", "%m/%d/%Y"),
        STR_TO_DATE("9/1/2019", "%m/%d/%Y"), FALSE, 18, 14, 8);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780156001311", "The Name of the Rose", "Mystery", 536,
        "The year is 1327. Benedictines in a wealthy Italian abbey are suspected of heresy, and Brother William of Baskerville arrives to investigate. When his delicate mission is suddenly overshadowed by seven bizarre deaths, Brother William turns detective. His tools are the logic of Aristotle, the theology of Aquinas, the empirical insights of Roger Bacon 2014all sharpened to a glistening edge by wry humor and a ferocious curiosity. He collects evidence, deciphers secret symbols and coded manuscripts, and digs into the eerie labyrinth of the abbey, where  201cthe most interesting things happen at night. 201d",
        STR_TO_DATE("9/28/1994", "%m/%d/%Y"), 1, STR_TO_DATE("9/28/2018", "%m/%d/%Y"),
        STR_TO_DATE("9/28/2019", "%m/%d/%Y"), FALSE, 19, 13, 5);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780582418271", "The Firm", "Mystery", 76,
        "Adaptation for younger readers.Mitch McDeere, a Harvard Law graduate, becomes suspicious of his Memphis tax firm when mysterious deaths, obsessive office security, and the Chicago mob figure into its operations.",
        STR_TO_DATE("2/15/2000", "%m/%d/%Y"), 1, STR_TO_DATE("2/15/2019", "%m/%d/%Y"),
        STR_TO_DATE("2/15/2019", "%m/%d/%Y"), FALSE, 15, 15, 7);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780380731862", "Shutter Island", "Mystery", 369,
        "The year is 1954. U.S. Marshal Teddy Daniels and his new partner, Chuck Aule, have come to Shutter Island, home of Ashecliffe Hospital for the Criminally Insane, to investigate the disappearance of a patient. Multiple murderess Rachel Solando is loose somewhere on this remote and barren island, despite having been kept in a locked cell under constant surveillance. As a killer hurricane relentlessly bears down on them, a strange case takes on even darker, more sinister shades 2014with hints of radical experimentation, horrifying surgeries, and lethal countermoves made in the cause of a covert shadow war. No one is going to escape Shutter Island unscathed, because nothing at Ashecliffe Hospital is what it seems. But then neither is Teddy Daniels.",
        STR_TO_DATE("4/27/2004", "%m/%d/%Y"), 1, STR_TO_DATE("4/27/2017", "%m/%d/%Y"),
        STR_TO_DATE("4/27/2019", "%m/%d/%Y"), FALSE, 19, 12, 7);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780060584757", "Mystic River", "Mystery", 416,
        "When they were children, Sean Devine, Jimmy Marcus, and Dave Boyle were friends. But then a strange car pulled up to their street. One boy got into the car, two did not, and something terrible happened -- something that ended their friendship and changed all three boys forever. Twenty-five years later, Sean is a homicide detective. Jimmy is an ex-con who owns a corner store. And Dave is trying to hold his marriage together and keep his demons at bay -- demons that urge him to do terrible things. When Jimmy\'s daughter is found murdered, Sean is assigned to the case. His investigation brings him into conflict with Jimmy, who finds his old criminal impulses tempt him to solve the crime with brutal justice. And then there is Dave, who came home the night Jimmy\'s daughter died covered in someone else\'s blood. A tense and unnerving psychological thriller, Mystic River is also an epic novel of love and loyalty, faith and family, in which people irrevocably marked by the past find themselves on a collision course with the darkest truths of their own hidden selves.",
        STR_TO_DATE("2/1/2001", "%m/%d/%Y"), 1, STR_TO_DATE("2/1/2019", "%m/%d/%Y"),
        STR_TO_DATE("2/1/2019", "%m/%d/%Y"), FALSE, 16, 10, 10);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780143034902", "The Shadow of the Wind", "Mystery", 487,
        "Barcelona, 1945. Just after the war, a great world city lies in shadow, nursing its wounds, and a boy named Daniel awakes on his eleventh birthday to find that he can no longer remember his mother 2019s face. To console his only child, Daniel 2019s widowed father, an antiquarian book dealer, initiates him into the secret of the Cemetery of Forgotten Books, a library tended by Barcelona 2019s guild of rare-book dealers as a repository for books forgotten by the world, waiting for someone who will care about them again. Daniel 2019s father coaxes him to choose a volume from the spiraling labyrinth of shelves, one that, it is said, will have a special meaning for him. And Daniel so loves the novel he selects, \"'The Shadow of the Wind'\", by one Julian Carax, that he sets out to find the rest of Carax 2019s work. To his shock, he discovers that someone has been systematically destroying every copy of every book this author has written. In fact, he may have the last one in existence. Before Daniel knows it his seemingly innocent quest has opened a door into one of Barcelona 2019s darkest secrets, an epic story of murder, magic, madness and doomed love. And before long he realizes that if he doesn 2019t find out the truth about Julian Carax, he and those closest to him will suffer horribly.",
        STR_TO_DATE("1/25/2005", "%m/%d/%Y"), 17, STR_TO_DATE("1/25/2017", "%m/%d/%Y"),
        STR_TO_DATE("1/25/2019", "%m/%d/%Y"), FALSE, 19, 12, 6);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780812976144", "The Alienist", "Mystery", 498,
        "When The Alienist was first published in 1994, it was a major phenomenon, spending six months on the New York Times bestseller list, receiving critical acclaim, and selling millions of copies. This modern classic continues to be a touchstone of historical suspense fiction for readers everywhere.The year is 1896. The city is New York. Newspaper reporter John Schuyler Moore is summoned by his friend Dr. Laszlo Kreizler 2014a psychologist, or  201calienist 201d 2014to view the horribly mutilated body of an adolescent boy abandoned on the unfinished Williamsburg Bridge. From there the two embark on a revolutionary effort in criminology: creating a psychological profile of the perpetrator based on the details of his crimes. Their dangerous quest takes them into the tortured past and twisted mind of a murderer who will kill again before their hunt is over.Fast-paced and riveting, infused with historical detail, The Alienist conjures up Gilded Age New York, with its tenements and mansions, corrupt cops and flamboyant gangsters, shining opera houses and seamy gin mills. It is an age in which questioning society 2019s belief that all killers are born, not made, could have unexpected and fatal consequences.",
        STR_TO_DATE("10/24/2006", "%m/%d/%Y"), 18, STR_TO_DATE("10/24/2018", "%m/%d/%Y"),
        STR_TO_DATE("10/24/2019", "%m/%d/%Y"), FALSE, 16, 12, 5);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780394758282", "The Big Sleep", "Mystery", 231,
        "Down these mean streets a man must go who is not himself mean, who is neither tarnished nor afraid....He is the hero; he is everything. He must be a complete man and a common man and yet an unusual man. This is the Code of the Private Eye as defined by Raymond Chandler in his 1944 essay \'The Simple Act of Murder.\' Such a man was Philip Marlowe, private eye, an educated, heroic, streetwise, rugged individualist and the hero of Chandler\'s first novel, The Big Sleep. This work established Chandler as the master of the ''hard-boiled'' detective novel, and his articulate and literary style of writing won him a large audience, which ranged from the man in the street to the most sophisticated intellectual. Marlowe subsequently appeared in a series of extremely popular novels, among them The Lady in the Lake, The Long Goodbye, and Farewell, My Lovely.\" ~ Elizabeth Diefendorf, editor, The New York Public Library''s Books of the Century, p. 112.Selected as one of Time Magazine''s All-Time 100 Novels, with the following review: \"'I was neat, clean, shaved and sober, and I didn\'t care who knew it. I was everything the well-dressed private detective ought to be.\' This sentence, from the first paragraph of The Big Sleep, marks the last time you can be fully confident that you know what\'s going on. The first novel by Raymond Chandler at the age of 51.",
        STR_TO_DATE("7/12/1988", "%m/%d/%Y"), 1, STR_TO_DATE("7/12/2019", "%m/%d/%Y"),
        STR_TO_DATE("7/12/2019", "%m/%d/%Y"), FALSE, 16, 13, 8);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780312362089", "One for the Money", "Mystery", 320,
        "You''ve lost your job as a department store lingerie buyer, your car\'s been repossessed, and most of your furniture and small appliances have been sold off to pay last month\'s rent. Now the rent is due again. And you live in New Jersey. What do you do?If you''re Stephanie Plum, you become a bounty hunter. But not just a nickel-and-dime bounty hunter; you go after the big money. That means a cop gone bad. And not just any cop. She goes after Joe Morelli, a disgraced former vice cop who is also the man who took Stephanie\'s virginity at age 16 and then wrote details on a bathroom wall. With pride and rent money on the line, Plum plunges headlong into her first case, one that pits her against ruthless adversaries - people who''d rather kill than lose.In Stephanie Plum, Evanovich has created a resourceful and humorous character who stands apart from the pack of gritty female detectives.",
        STR_TO_DATE("6/28/2005", "%m/%d/%Y"), 1, STR_TO_DATE("6/28/2017", "%m/%d/%Y"),
        STR_TO_DATE("6/28/2019", "%m/%d/%Y"), FALSE, 16, 11, 7);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780752865331", "The Maltese Falcon", "Mystery", 213,
        "Sam Spade is hired by the fragrant Miss Wonderley to track down her sister, who has eloped with a louse called Floyd Thursby. But Miss Wonderley is in fact the beautiful and treacherous Brigid O\'shaughnessy, and when Spade\'s partner Miles Archer is shot while on Thursby\'s trail, Spade finds himself both hunter and hunted: can he track down the jewel-encrusted bird, a treasure worth killing for, before the Fat Man finds him?",
        STR_TO_DATE("3/1/2005", "%m/%d/%Y"), 2, STR_TO_DATE("3/1/2018", "%m/%d/%Y"),
        STR_TO_DATE("3/1/2019", "%m/%d/%Y"), FALSE, 16, 12, 5);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780525945567", "Red Dragon", "Mystery", 348,
        "A second family has been massacred by the terrifying serial killer the press has christened \"The Tooth Fairy.\" Special Agent Jack Crawford turns to the one man who can help restart a failed investigation: Will Graham. Graham is the greatest profiler the FBI ever had, but the physical and mental scars of capturing Hannibal Lecter have caused Graham to go into early retirement. Now, Graham must turn to Lecter for help.",
        STR_TO_DATE("3/22/2000", "%m/%d/%Y"), 3, STR_TO_DATE("3/22/2019", "%m/%d/%Y"),
        STR_TO_DATE("3/22/2019", "%m/%d/%Y"), TRUE, 16, 15, 7);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780670038602", "In the Woods", "Mystery", 429,
        "The bestselling debut with over a million copies sold that launched Tana French,  201crequired reading for anyone who appreciates tough, unflinching intelligence and ingenious plotting 201d (The New York Times), who is  201cthe most interesting, most important crime novelist to emerge in the past 10 years 201d (The Washington Post)As dusk approaches a small Dublin suburb in the summer of 1984, mothers begin to call their children home. But on this warm evening, three children do not return from the dark and silent woods. When the police arrive, they find only one of the children gripping a tree trunk in terror, wearing blood-filled sneakers, and unable to recall a single detail of the previous hours.Twenty years later, the found boy, Rob Ryan, is a detective on the Dublin Murder Squad and keeps his past a secret. But when a twelve-year-old girl is found murdered in the same woods, he and Detective Cassie Maddox 2014his partner and closest friend 2014find themselves investigating a case chillingly similar to the previous unsolved mystery. Now, with only snippets of long-buried memories to guide him, Ryan has the chance to uncover both the mystery of the case before him and that of his own shadowy past.Richly atmospheric and stunning in its complexity, In the Woods is utterly convincing and surprising to the end.",
        STR_TO_DATE("3/17/2007", "%m/%d/%Y"), 1, STR_TO_DATE("3/17/2017", "%m/%d/%Y"),
        STR_TO_DATE("3/17/2019", "%m/%d/%Y"), FALSE, 17, 15, 8);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780446350983", "Presumed Innocent", "Mystery", 421,
        "Hailed as the most suspenseful and compelling novel in decades. Presumed Innocent brings to life our worst nightmare: that of an ordinary citizen facing conviction for the most terrible of all crimes. It\'s the stunning portrayal of one man\'s all-too-human, all-consuming fatal attraction for a passionate woman who is not his wife, and the story of how his obsession puts everything he loves and values on trial--including his own life. It\'s a book that lays bare a shocking world of betrayal and murder, as well as the hidden depths of the human heart. And it will hold you and haunt you...long after you have reached its shattering conclusion.--back cover",
        STR_TO_DATE("6/10/2005", "%m/%d/%Y"), 1, STR_TO_DATE("6/10/2018", "%m/%d/%Y"),
        STR_TO_DATE("6/10/2019", "%m/%d/%Y"), FALSE, 15, 13, 8);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780743298025", "The Thirteenth Tale", "Mystery", 406,
        "All children mythologize their birth...So begins the prologue of reclusive author Vida Winter\'s collection of stories, which are as famous for the mystery of the missing thirteenth tale as they are for the delight and enchantment of the twelve that do exist. The enigmatic Winter has spent six decades creating various outlandish life histories for herself -- all of them inventions that have brought her fame and fortune but have kept her violent and tragic past a secret. Now old and ailing, she at last wants to tell the truth about her extraordinary life. She summons biographer Margaret Lea, a young woman for whom the secret of her own birth, hidden by those who loved her most, remains an ever-present pain. Struck by a curious parallel between Miss Winter\'s story and her own, Margaret takes on the commission. As Vida disinters the life she meant to bury for good, Margaret is mesmerized. It is a tale of gothic strangeness featuring the Angelfield family, including the beautiful and willful Isabelle, the feral twins Adeline and Emmeline, a ghost, a governess, a topiary garden and a devastating fire. Margaret succumbs to the power of Vida\'s storytelling but remains suspicious of the author\'s sincerity. She demands the truth from Vida, and together they confront the ghosts that have haunted them while becoming, finally, transformed by the truth themselves. The Thirteenth Tale is a love letter to reading, a book for the feral reader in all of us, a return to that rich vein of storytelling that our parents loved and that we loved as children. Diane Setterfield will keep you guessing, make you wonder, move you to tears and laughter and, in the end, deposit you breathless yet satisfied back upon the shore of your everyday life.",
        STR_TO_DATE("11/12/2006", "%m/%d/%Y"), 1, STR_TO_DATE("11/12/2019", "%m/%d/%Y"),
        STR_TO_DATE("11/12/2019", "%m/%d/%Y"), FALSE, 15, 11, 10);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780812550702", "Ender\'s Game", "Science Fiction", 324,
        "Andrew \"Ender\" Wiggin thinks he is playing computer simulated war games; he is, in fact, engaged in something far more desperate. The result of genetic experimentation, Ender may be the military genius Earth desperately needs in a war against an alien enemy seeking to destroy all human life. The only way to find out is to throw Ender into ever harsher training, to chip away and find the diamond inside, or destroy him utterly. Ender Wiggin is six years old when it begins. He will grow up fast.But Ender is not the only result of the experiment. The war with the Buggers has been raging for a hundred years, and the quest for the perfect general has been underway almost as long. Ender\'s two older siblings, Peter and Valentine, are every bit as unusual as he is, but in very different ways. While Peter was too uncontrollably violent, Valentine very nearly lacks the capability for violence altogether. Neither was found suitable for the military\'s purpose. But they are driven by their jealousy of Ender, and by their inbred drive for power. Peter seeks to control the political process, to become a ruler. Valentine\'s abilities turn more toward the subtle control of the beliefs of commoner and elite alike, through powerfully convincing essays. Hiding their youth and identities behind the anonymity of the computer networks, these two begin working together to shape the destiny of Earth-an Earth that has no future at all if their brother Ender fails.Source: hatrack.com",
        STR_TO_DATE("9/30/2004", "%m/%d/%Y"), 1, STR_TO_DATE("9/30/2017", "%m/%d/%Y"),
        STR_TO_DATE("9/30/2017", "%m/%d/%Y"), FALSE, 20, 10, 7);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780141036144", "1984", "Science Fiction", 237,
        "Among the seminal texts of the 20th century, Nineteen Eighty-Four is a rare work that grows more haunting as its futuristic purgatory becomes more real. Published in 1949, the book offers political satirist George Orwell\'s nightmarish vision of a totalitarian, bureaucratic world and one poor stiff\'s attempt to find individuality. The brilliance of the novel is Orwell\'s prescience of modern life 2014the ubiquity of television, the distortion of the language 2014and his ability to construct such a thorough version of hell. Required reading for students since it was published, it ranks among the most terrifying novels ever written.",
        STR_TO_DATE("9/3/2013", "%m/%d/%Y"), 1, STR_TO_DATE("9/3/2019", "%m/%d/%Y"),
        STR_TO_DATE("9/3/2019", "%m/%d/%Y"), FALSE, 15, 13, 7);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780307887436", "Ready Player One", "Science Fiction", 374,
        "IN THE YEAR 2044, reality is an ugly place. The only time teenage Wade Watts really feels alive is when he\'s jacked into the virtual utopia known as the OASIS. Wade\'s devoted his life to studying the puzzles hidden within this world\'s digital confines, puzzles that are based on their creator\'s obsession with the pop culture of decades past and that promise massive power and fortune to whoever can unlock them. But when Wade stumbles upon the first clue, he finds himself beset by players willing to kill to take this ultimate prize. The race is on, and if Wade\'s going to survive, he''ll have to win 2014and confront the real world he\'s always been so desperate to escape.",
        STR_TO_DATE("8/16/2011", "%m/%d/%Y"), 1, STR_TO_DATE("8/16/2017", "%m/%d/%Y"),
        STR_TO_DATE("8/16/2019", "%m/%d/%Y"), FALSE, 20, 14, 9);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780593099322", "Dune", "Science Fiction", 688,
        "A deluxe hardcover edition of Frank Herbert\'s epic masterpiece--a triumph of the imagination and one of the bestselling science fiction novels of all time. This deluxe hardcover edition of Dune includes: - An iconic new cover- Stained edges and fully illustrated endpapers- A beautifully designed poster on the interior of the jacket- A redesigned world map of Dune- An updated Introduction by Brian HerbertSet on the desert planet Arrakis, Dune is the story of the boy Paul Atreides, heir to a noble family tasked with ruling an inhospitable world where the only thing of value is the \"spice\" melange, a drug capable of extending life and enhancing consciousness. Coveted across the known universe, melange is a prize worth killing for...When House Atreides is betrayed, the destruction of Paul\'s family will set the boy on a journey toward a destiny greater than he could ever have imagined. And as he evolves into the mysterious man known as Muad\'Dib, he will bring to fruition humankind\'s most ancient and unattainable dream.A stunning blend of adventure and mysticism, environmentalism and politics, Dune won the first Nebula Award, shared the Hugo Award, and formed the basis of what is undoubtedly the grandest epic in science fiction.\n\n",
        STR_TO_DATE("10/1/2019", "%m/%d/%Y"), 1, STR_TO_DATE("10/1/2018", "%m/%d/%Y"),
        STR_TO_DATE("10/1/2019", "%m/%d/%Y"), FALSE, 17, 14, 8);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9781451673319", "Fahrenheit 451", "Science Fiction", 194,
        "Guy Montag is a fireman. In his world, where television rules and literature is on the brink of extinction, firemen start fires rather than put them out. His job is to destroy the most illegal of commodities, the printed book, along with the houses in which they are hidden.Montag never questions the destruction and ruin his actions produce, returning each day to his bland life and wife, Mildred, who spends all day with her television ''family''. But then he meets an eccentric young neighbor, Clarisse, who introduces him to a past where people did not live in fear and to a present where one sees the world through the ideas in books instead of the mindless chatter of television.When Mildred attempts suicide and Clarisse suddenly disappears, Montag begins to question everything he has ever known.",
        STR_TO_DATE("11/29/2011", "%m/%d/%Y"), 15, STR_TO_DATE("11/29/2019", "%m/%d/%Y"),
        STR_TO_DATE("11/29/2019", "%m/%d/%Y"), FALSE, 15, 14, 9);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780804139021", "The Martian", "Science Fiction", 369,
        "u\'six days ago, astronaut Mark Watney became one of the first people to walk on Mars. Now, he 2019s sure he 2019ll be the first person to die there.After a dust storm nearly kills him and forces his crew to evacuate while thinking him dead, Mark finds himself stranded and completely alone with no way to even signal Earth that he 2019s alive 2014and even if he could get word out, his supplies would be gone long before a rescue could arrive. Chances are, though, he won 2019t have time to starve to death. The damaged machinery, unforgiving environment, or plain-old  201chuman error 201d are much more likely to kill him first. But Mark isn 2019t ready to give up yet. Drawing on his ingenuity, his engineering skills  2014 and a relentless, dogged refusal to quit  2014 he steadfastly confronts one seemingly insurmountable obstacle after the next. Will his resourcefulness be enough to overcome the impossible odds against him?",
        STR_TO_DATE("2/11/2014", "%m/%d/%Y"), 8, STR_TO_DATE("2/11/2018", "%m/%d/%Y"),
        STR_TO_DATE("2/11/2019", "%m/%d/%Y"), FALSE, 15, 13, 9);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780553803716", "Foundation", "Science Fiction", 244,
        "For twelve thousand years the Galactic Empire has ruled supreme. Now it is dying. But only Hari Seldon, creator of the revolutionary science of psychohistory, can see into the future -- to a dark age of ignorance, barbarism, and warfare that will last thirty thousand years. To preserve knowledge and save mankind, Seldon gathers the best minds in the Empire -- both scientists and scholars -- and brings them to a bleak planet at the edge of the Galaxy to serve as a beacon of hope for a future generations. He calls his sanctuary the Foundation.But soon the fledgling Foundation finds itself at the mercy of corrupt warlords rising in the wake of the receding Empire. Mankind\'s last best hope is faced with an agonizing choice: submit to the barbarians and be overrun -- or fight them and be destroyed.",
        STR_TO_DATE("6/1/2004", "%m/%d/%Y"), 16, STR_TO_DATE("6/1/2019", "%m/%d/%Y"),
        STR_TO_DATE("6/1/2019", "%m/%d/%Y"), FALSE, 16, 11, 7);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780439023498", "Catching Fire", "Science Fiction", 391,
        "Sparks are igniting.Flames are spreading.And the Capitol wants revenge.Against all odds, Katniss has won the Hunger Games. She and fellow District 12 tribute Peeta Mellark are miraculously still alive. Katniss should be relieved, happy even. After all, she has returned to her family and her longtime friend, Gale. Yet nothing is the way Katniss wishes it to be. Gale holds her at an icy distance. Peeta has turned his back on her completely. And there are whispers of a rebellion against the Capitol - a rebellion that Katniss and Peeta may have helped create.Much to her shock, Katniss has fueled an unrest she\'s afraid she cannot stop. And what scares her even more is that she\'s not entirely convinced she should try. As time draws near for Katniss and Peeta to visit the districts on the Capitol\'s cruel Victory Tour, the stakes are higher than ever. If they can''t prove, without a shadow of a doubt, that they are lost in their love for each other, the consequences will be horrifying.In Catching Fire, the second novel in the Hunger Games trilogy, Suzanne Collins continues the story of Katniss Everdeen, testing her more than ever before...and surprising readers at every turn.",
        STR_TO_DATE("9/1/2009", "%m/%d/%Y"), 1, STR_TO_DATE("9/1/2017", "%m/%d/%Y"),
        STR_TO_DATE("9/1/2019", "%m/%d/%Y"), TRUE, 19, 14, 9);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9781524796976", "Do Androids Dream of Electric Sheep?", "Science Fiction", 258,
        "It was January 2021, and Rick Deckard had a license to kill.Somewhere among the hordes of humans out there, lurked several rogue androids. Deckard\'s assignment--find them and then...\"retire\" them. Trouble was, the androids all looked exactly like humans, and they didn\'t want to be found!",
        STR_TO_DATE("2/26/2008", "%m/%d/%Y"), 1, STR_TO_DATE("2/26/2018", "%m/%d/%Y"),
        STR_TO_DATE("2/26/2019", "%m/%d/%Y"), FALSE, 17, 11, 7);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780439023511", "Mockingjay", "Science Fiction", 390,
        "My name is Katniss Everdeen.Why am I not dead?I should be dead.Katniss Everdeen, girl on fire, has survived, even though her home has been destroyed. Gale has escaped. Katniss\'s family is safe. Peeta has been captured by the Capitol. District 13 really does exist. There are rebels. There are new leaders. A revolution is unfolding.It is by design that Katniss was rescued from the arena in the cruel and haunting Quarter Quell, and it is by design that she has long been part of the revolution without knowing it. District 13 has come out of the shadows and is plotting to overthrow the Capitol. Everyone, it seems, has had a hand in the carefully laid plans--except Katniss.The success of the rebellion hinges on Katniss\'s willingness to be a pawn, to accept responsibility for countless lives, and to change the course of the future of Panem. To do this, she must put aside her feelings of anger and distrust. She must become the rebels'' Mockingjay--no matter what the personal cost.",
        STR_TO_DATE("8/24/2010", "%m/%d/%Y"), 1, STR_TO_DATE("8/24/2019", "%m/%d/%Y"),
        STR_TO_DATE("8/24/2019", "%m/%d/%Y"), FALSE, 16, 13, 5);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780486284729", "The Time Machine", "Science Fiction", 118,
        " 201cI 2019ve had a most amazing time.... 201dSo begins the Time Traveller 2019s astonishing firsthand account of his journey 800,000 years beyond his own era 2014and the story that launched H.G. Wells 2019s successful career and earned him his reputation as the father of science fiction. With a speculative leap that still fires the imagination, Wells sends his brave explorer to face a future burdened with our greatest hopes...and our darkest fears. A pull of the Time Machine 2019s lever propels him to the age of a slowly dying Earth.\xa0 There he discovers two bizarre races 2014the ethereal Eloi and the subterranean Morlocks 2014who not only symbolize the duality of human nature, but offer a terrifying portrait of the men of tomorrow as well.\xa0 Published in 1895, this masterpiece of invention captivated readers on the threshold of a new century. Thanks to Wells 2019s expert storytelling and provocative insight, The Time Machine will continue to enthrall readers for generations to come.\xa0",
        STR_TO_DATE("10/1/2002", "%m/%d/%Y"), 9, STR_TO_DATE("10/1/2017", "%m/%d/%Y"),
        STR_TO_DATE("10/1/2019", "%m/%d/%Y"), FALSE, 20, 11, 5);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780553803709", "I, Robot", "Science Fiction", 224,
        "The three laws of Robotics:1) A robot may not injure a human being or, through inaction, allow a human being to come to harm.2) A robot must obey orders given to it by human beings except where such orders would conflict with the First Law.3) A robot must protect its own existence as long as such protection does not conflict with the First or Second Law.With these three, simple directives, Isaac Asimov changed our perception of robots forever when he formulated the laws governing their behavior. In I, Robot, Asimov chronicles the development of the robot through a series of interlinked stories: from its primitive origins in the present to its ultimate perfection in the not-so-distant future--a future in which humanity itself may be rendered obsolete.Here are stories of robots gone mad, of mind-read robots, and robots with a sense of humor. Of robot politicians, and robots who secretly run the world--all told with the dramatic blend of science fact and science fiction that has become Asimov\'s trademark.",
        STR_TO_DATE("6/1/2004", "%m/%d/%Y"), 2, STR_TO_DATE("6/1/2018", "%m/%d/%Y"),
        STR_TO_DATE("6/1/2019", "%m/%d/%Y"), FALSE, 18, 14, 5);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780062024039", "Divergent", "Science Fiction", 487,
        "In Beatrice Prior\'s dystopian Chicago world, society is divided into five factions, each dedicated to the cultivation of a particular virtue 2014Candor (the honest), Abnegation (the selfless), Dauntless (the brave), Amity (the peaceful), and Erudite (the intelligent). On an appointed day of every year, all sixteen-year-olds must select the faction to which they will devote the rest of their lives. For Beatrice, the decision is between staying with her family and being who she really is 2014she can''t have both. So she makes a choice that surprises everyone, including herself.During the highly competitive initiation that follows, Beatrice renames herself Tris and struggles alongside her fellow initiates to live out the choice they have made. Together they must undergo extreme physical tests of endurance and intense psychological simulations, some with devastating consequences. As initiation transforms them all, Tris must determine who her friends really are 2014and where, exactly, a romance with a sometimes fascinating, sometimes exasperating boy fits into the life she\'s chosen. But Tris also has a secret, one she\'s kept hidden from everyone because she\'s been warned it can mean death. And as she discovers unrest and growing conflict that threaten to unravel her seemingly perfect society, she also learns that her secret might help her save those she loves . . . or it might destroy her.",
        STR_TO_DATE("2/28/2012", "%m/%d/%Y"), 1, STR_TO_DATE("2/28/2019", "%m/%d/%Y"),
        STR_TO_DATE("2/28/2019", "%m/%d/%Y"), TRUE, 20, 12, 9);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780441788385", "Stranger in a Strange Land", "Science Fiction", 528,
        "NAME: Valentine Michael SmithANCESTRY: HumanORIGIN: MarsValentine Michael Smith is a human being raised on Mars, newly returned to Earth. Among his people for the first time, he struggles to understand the social mores and prejudices of human nature that are so alien to him, while teaching them his own fundamental beliefs in grokking, watersharing, and love.",
        STR_TO_DATE("10/1/1991", "%m/%d/%Y"), 1, STR_TO_DATE("10/1/2017", "%m/%d/%Y"),
        STR_TO_DATE("10/1/2019", "%m/%d/%Y"), FALSE, 15, 10, 5);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780771008795", "The Handmaid\'s Tale", "Science Fiction", 312,
        "Offred is a Handmaid in the Republic of Gilead. She may leave the home of the Commander and his wife once a day to walk to food markets whose signs are now pictures instead of words because women are no longer allowed to read. She must lie on her back once a month and pray that the Commander makes her pregnant, because in an age of declining births, Offred and the other Handmaids are valued only if their ovaries are viable. Offred can remember the years before, when she lived and made love with her husband, Luke; when she played with and protected her daughter; when she had a job, money of her own, and access to knowledge. But all of that is gone now . . . Funny, unexpected, horrifying, and altogether convincing, The Handmaid\'s Tale is at once scathing satire, dire warning, and tour de force.",
        STR_TO_DATE("4/4/1998", "%m/%d/%Y"), 17, STR_TO_DATE("4/4/2018", "%m/%d/%Y"),
        STR_TO_DATE("4/4/2019", "%m/%d/%Y"), TRUE, 18, 13, 7);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9781509808335", "The Restaurant at the End of the Universe", "Science Fiction", 250,
        "Alternate Cover Edition ISBN 0345418921 (ISBN13: 9780345418920)Facing annihilation at the hands of the warlike Vogons is a curious time to have a cosmically displaced Arthur Dent and his curious comrades in arms as they hurtle through space powered by pure improbability - and desperately in search of a place to eat. Among Arthur\'s motley shipmates are Ford Prefect, a long-time friend and contributor to the The Hitch Hiker\'s Guide to the Galaxy; Zaphod Beeblebrox, the three-armed, two-headed ex-president of the galaxy; Tricia McMilan, a fellow Earth refuge who\'s gone native (her name is Trillian now); and Marvin, who suffers nothing and no one gladly.Source: douglasadams.com",
        STR_TO_DATE("4/26/2005", "%m/%d/%Y"), 18, STR_TO_DATE("4/26/2019", "%m/%d/%Y"),
        STR_TO_DATE("4/26/2019", "%m/%d/%Y"), FALSE, 19, 13, 6);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780345538987", "Jurassic Park", "Science Fiction", 466,
        "An astonishing technique for recovering and cloning dinosaur DNA has been discovered. Now humankind 2019s most thrilling fantasies have come true. Creatures extinct for eons roam Jurassic Park with their awesome presence and profound mystery, and all the world can visit them 2014for a price. Until something goes wrong. . . . In Jurassic Park, Michael Crichton taps all his mesmerizing talent and scientific brilliance to create his most electrifying technothriller.",
        STR_TO_DATE("5/14/2012", "%m/%d/%Y"), 1, STR_TO_DATE("5/14/2017", "%m/%d/%Y"),
        STR_TO_DATE("5/14/2017", "%m/%d/%Y"), FALSE, 17, 10, 8);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780451457998", "2001: A Space Odyssey", "Science Fiction", 297,
        "On the Moon, an enigma is uncovered.So great are the implications of this discovery that for the first time men are sent out deep into our solar system.But long before their destination is reached, things begin to go horribly, inexplicably wrong...One of the greatest-selling science fiction novels of our time, this classic book will grip you to the very end.",
        STR_TO_DATE("9/1/2000", "%m/%d/%Y"), 1, STR_TO_DATE("9/1/2018", "%m/%d/%Y"),
        STR_TO_DATE("9/1/2019", "%m/%d/%Y"), FALSE, 20, 14, 5);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780989671767", "Unsouled", "Fantasy", 294,
        "Sacred artists follow a thousand Paths to power, using their souls to control the forces of the natural world. Lindon is Unsouled, forbidden to learn the sacred arts of his clan. When faced with a looming fate he cannot ignore, he must defy his family\'s rules...and forge his own Path.",
        STR_TO_DATE("6/13/2016", "%m/%d/%Y"), 1, STR_TO_DATE("6/13/2019", "%m/%d/%Y"),
        STR_TO_DATE("6/13/2019", "%m/%d/%Y"), FALSE, 20, 13, 7);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780989671774", "Soulsmith", "Fantasy", 286,
        "Outside Sacred Valley, ancient ruins rise from the earth, drawing sacred artists from miles around to fight for the treasures within. Lindon has reached Copper, taking the first step on the road to power, but the warriors of the outside world are still far beyond him. To advance, he turns to the arcane skills of the Soulsmiths, who craft weapons from the stuff of souls. With new powers come new enemies, and Lindon soon finds himself facing an entire sect of Golds.",
        STR_TO_DATE("9/26/2016", "%m/%d/%Y"), 4, STR_TO_DATE("9/26/2017", "%m/%d/%Y"),
        STR_TO_DATE("9/26/2017", "%m/%d/%Y"), FALSE, 18, 12, 8);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780989671781", "Blackflame", "Fantasy", 370,
        "Lindon has a year left. When his time runs out, he 2019ll have to fight an opponent that no one believes he can beat. Unless he learns sacred arts the right way, from scratch, he won 2019t have a chance to win 2026and even then, the odds are against him. In the course of their training, he and Yerin travel to the Blackflame Empire, where they fight to master an ancient power. Success means a chance at life, but failure means death. In the sacred arts, only those who risk the most can travel far.",
        STR_TO_DATE("4/30/2017", "%m/%d/%Y"), 5, STR_TO_DATE("4/30/2017", "%m/%d/%Y"),
        STR_TO_DATE("4/30/2017", "%m/%d/%Y"), FALSE, 16, 11, 5);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780999851104", "Skysworn", "Fantasy", 292,
        "With his duel fast approaching, Lindon is locked away in prison. As a Blackflame, he is too dangerous to remain free. The Skysworn, protectors of the Empire, have imprisoned him to keep him under control until the day of his promised fight arrives. When it does, he will face Jai Long. But a new danger approaches the Empire, closer every day. Only the Skysworn stand between the people of the land and total annihilation. And Lindon may be forced to join them.",
        STR_TO_DATE("9/30/2017", "%m/%d/%Y"), 6, STR_TO_DATE("9/30/2017", "%m/%d/%Y"),
        STR_TO_DATE("9/30/2017", "%m/%d/%Y"), FALSE, 15, 15, 9);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780999851111", "Ghostwater", "Fantasy", 310,
        "Long ago, the Monarch Northstrider created a world of his own. This world, known as Ghostwater, housed some of his most valuable experiments. Now, it has been damaged by the attack of the Bleeding Phoenix, and a team of Skysworn have been sent to recover whatever they can from the dying world. Now, Lindon must brave the depths of this new dimension, scavenging treasures and pushing his skills to new heights to compete with new enemies. Because Ghostwater is not as empty as it seems.",
        STR_TO_DATE("5/31/2018", "%m/%d/%Y"), 7, STR_TO_DATE("5/31/2018", "%m/%d/%Y"),
        STR_TO_DATE("5/31/2018", "%m/%d/%Y"), FALSE, 17, 12, 10);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780999851128", "Underlord", "Fantasy", 308,
        "A tournament approaches. All around the world, great clans and sects prepare their disciples to fight against one another in a competition of young Underlords. Even the Blackflame Empire is drawn in, but their youth are not strong enough to compete. Yet.",
        STR_TO_DATE("3/1/2019", "%m/%d/%Y"), 13, STR_TO_DATE("3/1/2019", "%m/%d/%Y"),
        STR_TO_DATE("3/1/2019", "%m/%d/%Y"), FALSE, 18, 10, 6);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780999851135", "Uncrowned", "Fantasy", 288,
        "Emriss Silentborn, Memory of the World.Tiberian Arelius, the fallen Patriarch.Akura Malice, Queen of Shadows.Seshethkunaaz, King of Dragons.Reigan Shen, Emperor of Lions.Luminous Queen Sha Miara.The Eight-Man Empire.Northstrider.The Monarchs, the most powerful sacred artists on Cradle, rule with unquestioned authority. They are mysterious and distant, and catching a glimpse of one is privilege enough for a lifetime.Now, they have all gathered in one place, bringing their heirs and greatest students together for a competition to determine whose successor is the best in the world:The Uncrowned King tournament.",
        STR_TO_DATE("9/26/2019", "%m/%d/%Y"), 1, STR_TO_DATE("9/26/2019", "%m/%d/%Y"),
        STR_TO_DATE("9/26/2019", "%m/%d/%Y"), FALSE, 17, 10, 9);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780316075558", "The Black Prism", "Fantasy", 629,
        "Guile is the Prism, the most powerful man in the world. He is high priest and emperor, a man whose power, wit, and charm are all that preserves a tenuous peace. Yet Prisms never last, and Guile knows exactly how long he has left to live.When Guile discovers he has a son, born in a far kingdom after the war that put him in power, he must decide how much he\'s willing to pay to protect a secret that could tear his world apart.",
        STR_TO_DATE("8/25/2010", "%m/%d/%Y"), 8, STR_TO_DATE("8/25/2017", "%m/%d/%Y"),
        STR_TO_DATE("8/25/2017", "%m/%d/%Y"), FALSE, 18, 14, 8);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780316079914", "The Blinding Knife", "Fantasy", 671,
        "Gavin Guile is dying.He 2019d thought he had five years left 2014now he has less than one. With fifty thousand refugees, a bastard son, and an ex-fianc\xe9e who may have learned his darkest secret, Gavin has problems on every side. All magic in the world is running wild and threatens to destroy the Seven Satrapies.Worst of all, the old gods are being reborn, and their army of color wights is unstoppable. The only salvation may be the brother whose freedom and life Gavin stole sixteen years ago.",
        STR_TO_DATE("9/11/2012", "%m/%d/%Y"), 9, STR_TO_DATE("9/11/2018", "%m/%d/%Y"),
        STR_TO_DATE("9/11/2018", "%m/%d/%Y"), FALSE, 15, 10, 7);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780316058964", "The Broken Eye", "Fantasy", 846,
        "As the old gods awaken, the Chromeria is in a race to find its lost Prism, the only man who may be able to stop catastrophe, Gavin Guile. But Gavin\'s enslaved on a galley, and when he finally escapes, he finds himself in less than friendly hands. Without the ability to draft which has defined him . . .Meanwhile, the Color Prince\'s army continues its inexorable advance, having swallowed two of the seven satrapies, they now invade the Blood Forest. Andross Guile, thinking his son Gavin lost, tasks his two grandsons with stopping the advance. Kip and his psychopathic half-brother Zymun will compete for the ultimate prize: who will become the next Prism.",
        STR_TO_DATE("8/26/2014", "%m/%d/%Y"), 1, STR_TO_DATE("8/26/2019", "%m/%d/%Y"),
        STR_TO_DATE("8/26/2019", "%m/%d/%Y"), FALSE, 18, 10, 10);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780316251334", "The Blood Mirror", "Fantasy", 704,
        "Stripped of both magical and political power, the people he once ruled told he\'s dead, and now imprisoned in his own magical dungeon, former Emperor Gavin Guile has no prospect of escape. But the world faces a calamity greater than the Seven Satrapies has ever seen... and only he can save it.As the armies of the White King defeat the Chromeria and old gods are born anew, the fate of worlds will come down to one question: Who is the Lightbringer?LightbringerThe Black PrismThe Blinding KnifeThe Broken EyeThe Blood Mirror",
        STR_TO_DATE("10/25/2016", "%m/%d/%Y"), 10, STR_TO_DATE("10/25/2017", "%m/%d/%Y"),
        STR_TO_DATE("10/25/2017", "%m/%d/%Y"), FALSE, 18, 12, 8);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780316251303", "The Burning White", "Fantasy", 992,
        "The nail-biting conclusion to the Lightbringer series! Stripped of both magical and political power, the people he once ruled told he\'s dead, and now imprisoned in his own magical dungeon, former Emperor Gavin Guile has no prospect of escape. But the world faces a calamity greater than the Seven Satrapies has ever seen... and only he can save it.As the armies of the White King defeat the Chromeria and old gods are born anew, the fate of worlds will come down to one question: Who is the Lightbringer?",
        STR_TO_DATE("10/22/2019", "%m/%d/%Y"), 11, STR_TO_DATE("10/22/2019", "%m/%d/%Y"),
        STR_TO_DATE("10/22/2019", "%m/%d/%Y"), FALSE, 20, 12, 6);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780765311788", "The Final Empire", "Fantasy", 541,
        "Where ash falls from the sky, and mist dominates the night, evil cloaks the land and stifles all life. Criminal mastermind Kelsier teaches Allomancy, the magic of metals, to another Mistborn, urchin Vin 16. The unlikely heroine is distracted by rich Venture heir Elend. Can Kelsier\'s thieving crew take on the tyrant Lord Ruler and bring back colour to their world?",
        STR_TO_DATE("6/25/2006", "%m/%d/%Y"), 1, STR_TO_DATE("6/25/2017", "%m/%d/%Y"),
        STR_TO_DATE("6/25/2017", "%m/%d/%Y"), FALSE, 19, 12, 9);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780765316882", "The Well of Ascension", "Fantasy", 590,
        "Vin, the street urchin who has grown into the most powerful Mistborn in the land, and Elend Venture, the idealistic young nobleman who loves her, must build a healthy new society in the ashes of an empire. Three separate armies attack. As the siege tightens, an ancient legend seems to offer a glimmer of hope. But even if it really exists, no one knows where to find the Well of Ascension or what manner of power it bestows.",
        STR_TO_DATE("8/21/2007", "%m/%d/%Y"), 12, STR_TO_DATE("8/21/2017", "%m/%d/%Y"),
        STR_TO_DATE("8/21/2017", "%m/%d/%Y"), FALSE, 18, 15, 5);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780765316899", "The Hero of Ages", "Fantasy", 572,
        "Tricked into releasing the evil spirit Ruin while attempting to close the Well of Ascension, new emperor Elend Venture and his wife, the assassin Vin, are now hard-pressed to save the world.",
        STR_TO_DATE("10/14/2008", "%m/%d/%Y"), 14, STR_TO_DATE("10/14/2018", "%m/%d/%Y"),
        STR_TO_DATE("10/14/2018", "%m/%d/%Y"), FALSE, 18, 12, 8);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780765330420", "The Alloy of Law", "Fantasy", 332,
        "Three hundred years after the events of the Mistborn trilogy, Scadrial is now on the verge of modernity, with railroads to supplement the canals, electric lighting in the streets and the homes of the wealthy, and the first steel-framed skyscrapers racing for the clouds.Kelsier, Vin, Elend, Sazed, Spook, and the rest are now part of history 2014or religion. Yet even as science and technology are reaching new heights, the old magics of Allomancy and Feruchemy continue to play a role in this reborn world. Out in the frontier lands known as the Roughs, they are crucial tools for the brave men and women attempting to establish order and justice.One such is Waxillium Ladrian, a rare Twinborn who can Push on metals with his Allomancy and use Feruchemy to become lighter or heavier at will. After twenty years in the Roughs, Wax has been forced by family tragedy to return to the metropolis of Elendel. Now he must reluctantly put away his guns and assume the duties and dignity incumbent upon the head of a noble house. Or so he thinks, until he learns the hard way that the mansions and elegant tree-lined streets of the city can be even more dangerous than the dusty plains of the Roughs.",
        STR_TO_DATE("11/8/2011", "%m/%d/%Y"), 1, STR_TO_DATE("11/8/2019", "%m/%d/%Y"),
        STR_TO_DATE("11/8/2019", "%m/%d/%Y"), FALSE, 15, 15, 7);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780765378552", "Shadows of Self", "Fantasy", 383,
        "u\'shadows of Self shows Mistborn 2019s society evolving as technology and magic mix, the economy grows, democracy contends with corruption, and religion becomes a growing cultural force, with four faiths competing for converts.This bustling, optimistic, but still shaky society now faces its first instance of terrorism, crimes intended to stir up labor strife and religious conflict. Wax and Wayne, assisted by the lovely, brilliant Marasi, must unravel the conspiracy before civil strife stops Scadrial 2019s progress in its tracks.Shadows of Self will give fans of The Alloy of Law everything they 2019ve been hoping for and, this being a Brandon Sanderson book, more, much more.",
        STR_TO_DATE("10/6/2015", "%m/%d/%Y"), 1, STR_TO_DATE("10/6/2017", "%m/%d/%Y"),
        STR_TO_DATE("10/6/2017", "%m/%d/%Y"), FALSE, 17, 14, 9);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9781466862678", "The Bands of Mourning", "Fantasy", 448,
        "From #1 New York Times bestselling author Brandon Sanderson, the Mistborn series is a heist story of political intrigue and magical, martial-arts action. Three hundred years after the events of the Mistborn trilogy, Scadrial is now on the verge of modernity, with railroads to supplement the canals, electric lighting in the streets and the homes of the wealthy, and the first steel-framed skyscrapers racing for the clouds.The Bands of Mourning are the mythical metal minds owned by the Lord Ruler, said to grant anyone who wears them the powers that the Lord Ruler had at his command. Hardly anyone thinks they really exist. A kandra researcher has returned to Elendel with images that seem to depict the Bands, as well as writings in a language that no one can read. Waxillium Ladrian is recruited to travel south to the city of New Seran to investigate. Along the way he discovers hints that point to the true goals of his uncle Edwarn and the shadowy organization known as The Set.",
        STR_TO_DATE("1/26/2016", "%m/%d/%Y"), 3, STR_TO_DATE("1/26/2018", "%m/%d/%Y"),
        STR_TO_DATE("1/26/2019", "%m/%d/%Y"), FALSE, 19, 11, 6);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780756404079", "The Name of the Wind", "Fantasy", 662,
        "Told in Kvothe\'s own voice, this is the tale of the magically gifted young man who grows to be the most notorious wizard his world has ever seen. The intimate narrative of his childhood in a troupe of traveling players, his years spent as a near-feral orphan in a crime-ridden city, his daringly brazen yet successful bid to enter a legendary school of magic, and his life as a fugitive after the murder of a king form a gripping coming-of-age story unrivaled in recent literature. A high-action story written with a poet\'s hand, The Name of the Wind is a masterpiece that will transport readers into the body and mind of a wizard.",
        STR_TO_DATE("4/7/2020", "%m/%d/%Y"), 2, STR_TO_DATE("4/7/2019", "%m/%d/%Y"),
        STR_TO_DATE("4/7/2019", "%m/%d/%Y"), FALSE, 15, 13, 7);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780756404734", "The Wise Man\'s Fear", "Fantasy", 994,
        " 201cThere are three things all wise men fear: the sea in storm, a night with no moon, and the anger of a gentle man. 201dMy name is Kvothe.I have stolen princesses back from sleeping barrow kings. I burned down the town of Trebon. I have spent the night with Felurian and left with both my sanity and my life. I was expelled from the University at a younger age than most people are allowed in. I tread paths by moonlight that others fear to speak of during day. I have talked to Gods, loved women, and written songs that make the minstrels weep.You may have heard of me.So begins the tale of a hero told from his own point of view  2014 a story unequaled in fantasy literature. Now in The Wise Man\'s Fear, an escalating rivalry with a powerful member of the nobility forces Kvothe to leave the University and seek his fortune abroad. Adrift, penniless, and alone, he travels to Vintas, where he quickly becomes entangled in the politics of courtly society. While attempting to curry favor with a powerful noble, Kvothe uncovers an assassination attempt, comes into conflict with a rival arcanist, and leads a group of mercenaries into the wild, in an attempt to solve the mystery of who (or what) is waylaying travelers on the King\'s Road.All the while, Kvothe searches for answers, attempting to uncover the truth about the mysterious Amyr, the Chandrian, and the death of his parents. Along the way, Kvothe is put on trial by the legendary Adem mercenaries, is forced to reclaim the honor of the Edema Ruh, and travels into the Fae realm. There he meets Felurian, the faerie woman no man can resist, and who no man has ever survived ... until Kvothe.In The Wise Man\'s Fear, Kvothe takes his first steps on the path of the hero and learns how difficult life can be when a man becomes a legend in his own time.",
        STR_TO_DATE("3/1/2011", "%m/%d/%Y"), 1, STR_TO_DATE("3/1/2017", "%m/%d/%Y"),
        STR_TO_DATE("3/1/2019", "%m/%d/%Y"), FALSE, 17, 14, 8);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9781937007294", "Fated", "Fantasy", 295,
        "Alex Verus is part of a world hidden in plain sight, running a magic shop in London. And while Alex\'s own powers aren''t as showy as some mages, he does have the advantage of foreseeing the possible future--allowing him to pull off operations that have a million-to-one-chance of success. But when Alex is approached by multiple factions to crack open a relic from a long-ago mage war, he knows that whatever\'s inside must be beyond powerful. And thanks to his abilities, Alex can predict that by taking the job, his odds of survival are about to go from slim to none...",
        STR_TO_DATE("2/28/2012", "%m/%d/%Y"), 3, STR_TO_DATE("2/28/2018", "%m/%d/%Y"),
        STR_TO_DATE("2/28/2019", "%m/%d/%Y"), FALSE, 19, 10, 10);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9781937007591", "Cursed", "Fantasy", 293,
        "Benedict Jacka\'s acclaimed Alex Verus series continues with Cursed.Since his second sight made him infamous for defeating powerful dark mages, Alex has been keeping his head down. But now he\'s\xa0discovered the resurgence of a forbidden ritual. Someone is harvesting the life-force of magical creatures 2014destroying them in the process. And draining humans is next on the agenda. Hired to investigate, Alex\xa0realizes that\xa0not everyone on the Council wants him delving any deeper. Struggling to distinguish ally from enemy, he finds himself the target of those who would risk their own sanity for power...",
        STR_TO_DATE("5/29/2012", "%m/%d/%Y"), 2, STR_TO_DATE("5/29/2019", "%m/%d/%Y"),
        STR_TO_DATE("5/29/2019", "%m/%d/%Y"), FALSE, 18, 14, 7);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9781937007720", "Taken", "Fantasy", 313,
        "Mage apprentices have been vanishing without a trace 2014and someone on the council might be involved. Alex Verus has no evidence, no witnesses, and no suspects. All he knows is that someone is keeping tabs on him. And after assassins target his own apprentice 2019s classmate, Alex sees that he doesn 2019t know the half of it 2014and that he could be the next to disappear...",
        STR_TO_DATE("8/28/2012", "%m/%d/%Y"), 3, STR_TO_DATE("8/28/2017", "%m/%d/%Y"),
        STR_TO_DATE("8/28/2019", "%m/%d/%Y"), FALSE, 19, 13, 7);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780425264928", "Chosen", "Fantasy", 294,
        "I don 2019t publicly advertise that I 2019m a mage, but I don 2019t exactly hide it either, and one of the odd things I 2019ve learnt over the years is just how much you can get away with if you 2019re blatant enough. Hide something behind smoke and mirrors and make people work to find it, and they 2019ll tear the place down looking for what 2019s there. Alex Verus is a diviner who can see probable futures 2014a talent that 2019s gotten him out of many a tough scrape. But this time, he may be in over his head. Alex was once apprenticed to a Dark mage, and in his service he did a lot of things he isn 2019t proud of. As rumors swirl that his old master is coming back, Alex comes face to face with his misdeeds in the form of a young adept whose only goal is to get revenge. Alex has changed his life for the better, but he 2019s afraid of what his friends 2014including his apprentice, Luna 2014will think of his past. But if they 2019re going to put themselves at risk, they need to know exactly what kind of man they 2019re fighting for...",
        STR_TO_DATE("8/27/2013", "%m/%d/%Y"), 4, STR_TO_DATE("8/27/2018", "%m/%d/%Y"),
        STR_TO_DATE("8/27/2019", "%m/%d/%Y"), FALSE, 16, 14, 6);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780425264942", "Hidden", "Fantasy", 336,
        "Alternate cover edition of ASIN B00HP4HC2SAlex Verus is a diviner who can see probable futures - a talent that\'s gotten him and his friends out of many a tough scrape. But what happens when someone doesn''t want Alex\'s help?Alex\'s friend, the life mage Anne, distanced herself from him when she found out about his past as a Dark apprentice. Now she\'s in serious trouble, but wants nothing to do with him. Alex has to start wondering if Anne\'s problem is really with him - or if there\'s a secret she\'s trying to hide.On top of that, rumours are swirling around London that Alex\'s former master may be back in town. Alex has no idea what his agenda may be, or who it involves . . .",
        STR_TO_DATE("9/2/2014", "%m/%d/%Y"), 4, STR_TO_DATE("9/2/2019", "%m/%d/%Y"),
        STR_TO_DATE("9/2/2019", "%m/%d/%Y"), FALSE, 19, 14, 9);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780425275757", "Veiled", "Fantasy", 304,
        "National bestselling author Benedict Jacka returns to the world of Alex Verus...I thought I 2019d escaped my past. But my old master is back and making a new play for power. And he 2019s not the only one targeting me 2026Diviner Alex Verus and the Council that governs the magical community have never gotten along. But with his former teacher back in Britain, Alex is in desperate need of allies, and he 2019ll do whatever it takes to get them 2014even if it means accepting a job with the Keepers, enforcing magical law.Alex forms an uneasy alliance with his new partner, Caldera, but his attempt at legitimacy quickly turns lethal when a mission puts him in possession of an item that factions both inside and outside of the Council would kill to get their hands on.Once again caught in the middle of a deadly conflict, Alex will need all his abilities to figure out who his friends are 2014especially when enemies are hiding on all sides 2026",
        STR_TO_DATE("8/4/2015", "%m/%d/%Y"), 6, STR_TO_DATE("8/4/2017", "%m/%d/%Y"),
        STR_TO_DATE("8/4/2019", "%m/%d/%Y"), FALSE, 16, 10, 9);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780698165083", "Burned", "Fantasy", 326,
        "Mage Alex Verus is back in the seventh in the  201cgorgeously realized 201d* urban fantasy series from the national bestselling author of Veiled. I 2019m used to people wanting me dead. But, this time, I 2019m not the only one on the hit list 2014and time is running out... Diviner Alex Verus finally made one too many enemies on the Council of Mages, and now one of them is angry enough to have him executed. Fighting for his life is nothing new, but this kill order also calls for the death of Alex 2019s dependents 2014and there 2019s no way that he 2019ll let Luna, Anne, and Vari take the heat. With only a week before he 2019s history, Alex will have to figure out how to disassociate himself from his friends, scrounge up allies on the Council, and hopefully keep his head attached to his body. But saving himself is going to bring him into direct opposition with his former master and the Dark mages surrounding him. And, this time, escaping with his life might mean losing his soul...",
        STR_TO_DATE("4/7/2016", "%m/%d/%Y"), 5, STR_TO_DATE("4/7/2018", "%m/%d/%Y"),
        STR_TO_DATE("4/7/2019", "%m/%d/%Y"), FALSE, 17, 12, 9);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9781101988527", "Bound", "Fantasy", 336,
        "Mage Alex Verus is caught between a rock and a hard place in the eighth urban fantasy novel from the national bestselling author of Burned.Right now I wasn 2019t seeing Richard as the teacher out of my nightmares, he was just another Dark mage, and I looked into the future to see what would happen if I turned that knife on him instead... Alex Verus is still haunted by his time apprenticed to Richard Drakh. He\'s been free of him for many years, but now the only way to keep his friends from being harmed is to again work for Richard and his deadly ally. Even worse, he 2019s forced to bring the Light mage Anne into this servitude as well. After weeks of being hunted and finally cornered into what he thought was his last stand, Alex never thought his life would be spared 2014and never anticipated at what price. This time, the diviner can see no way out...",
        STR_TO_DATE("4/4/2017", "%m/%d/%Y"), 7, STR_TO_DATE("4/4/2017", "%m/%d/%Y"),
        STR_TO_DATE("4/4/2019", "%m/%d/%Y"), FALSE, 18, 13, 6);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780356507217", "Marked", "Fantasy", 354,
        "Mage Alex Verus is hanging on by a thread in the ninth urban fantasy novel from the national bestselling author of Burned.When Mage Alex Verus ends up with a position on the Light Council, no one is happy, least of all him. But Alex is starting to realize that if he wants to protect his friends, he''ll need to become a power player himself. His first order of business is to track down dangerous magical items unleashed into the world by Dark Mages.But when the Council decides they need his help in negotiating with the perpetrators, Alex will have to use all his cunning and magic to strike a deal--and stop the rising tension between the Council, the Dark Mages, and the adept community from turning into a bloodbath.",
        STR_TO_DATE("6/5/2018", "%m/%d/%Y"), 5, STR_TO_DATE("6/5/2018", "%m/%d/%Y"),
        STR_TO_DATE("6/5/2019", "%m/%d/%Y"), FALSE, 16, 14, 5);
INSERT INTO Book
(ISBN, Title, Genre, Num_Of_Pages, Description, Date_Of_Publication, Publisher_ID, Date_Entered, Last_Modified,
 Is_Removed, List_Price, Sale_Price, Wholesale_Price)
VALUES ("9780440000587", "Fallen", "Fantasy", 296,
        "For Mage Alex Verus, everything is on the line in the tenth urban fantasy novel from the national bestselling author of Marked.Once Alex Verus was a diviner trying to live quietly under the radar. Now he\'s a member of the Light Council who\'s found success, friends...and love. But it\'s come with a price--the Council is investigating him, and if they find out the truth, he''ll lose everything.Meanwhile, Alex\'s old master, Richard Drakh, is waging a war against the Council, and he\'s preparing a move that will bring Alex and the life mage, Anne, under his control. Caught between Richard and the Council, Alex\'s time is running out. To protect those he cares for, Alex will have to become something different. Something darker...",
        STR_TO_DATE("9/24/2019", "%m/%d/%Y"), 6, STR_TO_DATE("9/24/2019", "%m/%d/%Y"),
        STR_TO_DATE("9/24/2019", "%m/%d/%Y"), FALSE, 17, 15, 5);

## Authors
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("John Steinbeck", false, "2019-03-25 19:21:49", "2020-11-11 04:47:09");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Louis Sachar", true, "2019-07-03 22:46:15", "2020-01-06 12:12:52");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Harper Lee", false, "2019-01-04 04:47:47", "2020-09-24 01:46:11");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("F. Scott Fitzgerald", true, "2019-09-15 17:32:09", "2020-08-08 16:26:12");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("J.K. Rowling, Mary GrandPrï¿½", false, "2019-06-15 14:51:53", "2019-08-13 11:44:24");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("George Orwell, Russell Baker", true, "2019-11-16 02:26:05", "2019-10-05 10:16:51");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("J.D. Salinger", false, "2019-08-07 15:17:48", "2019-12-09 12:35:34");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Khaled Hosseini", false, "2019-04-23 07:02:41", "2021-04-09 14:37:02");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("William Golding", false, "2019-07-14 09:21:21", "2020-07-03 03:59:01");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Jane Austen, Anna Quindlen", false, "2019-05-24 03:06:27", "2020-11-15 10:48:04");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Paulo Coelho", false, "2019-05-12 05:11:53", "2019-01-04 05:05:15");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Yann Martel", true, "2019-12-14 15:27:12", "2021-03-14 02:58:40");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Markus Zusak", false, "2019-11-25 16:21:30", "2021-01-13 15:56:21");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Bram Stoker, Nina Auerbach", false, "2019-04-30 01:30:02", "2019-07-18 00:24:20");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Mary Wollstonecraft Shelley, Percy Bysshe Shelley", true, "2019-03-21 16:12:38", "2021-04-12 04:02:59");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Mark Z. Danielewski", false, "2019-12-19 00:43:13", "2020-10-16 18:44:26");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Shirley Jackson, Laura Miller", false, "2019-11-26 15:33:50", "2019-10-11 17:50:22");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("William Peter Blatty", false, "2019-04-19 22:07:08", "2019-07-26 02:06:48");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Anne Rice", true, "2020-01-15 14:23:54", "2020-11-28 14:18:46");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Alma Katsu", true, "2019-08-29 14:52:35", "2020-11-07 19:12:35");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Max Brooks", false, "2019-08-16 17:12:16", "2021-04-03 02:38:53");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Richard Matheson", true, "2019-04-11 13:34:51", "2021-01-08 19:40:42");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Joe Hill", false, "2019-09-30 02:50:24", "2019-05-12 06:46:31");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Neil Gaiman", false, "2019-08-23 18:44:21", "2019-07-20 17:31:53");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Peter Straub", false, "2019-01-05 12:24:54", "2019-02-09 06:01:00");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Justin Cronin", false, "2019-04-26 03:27:49", "2021-01-28 00:41:00");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Josh Malerman", true, "2019-10-19 20:26:57", "2019-12-31 00:52:47");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Stephen King", false, "2019-04-29 03:25:00", "2019-01-14 12:22:28");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Stieg Larsson, Reg Keeland", false, "2019-11-24 15:05:55", "2019-12-23 14:13:36");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Agatha Christie", false, "2019-09-07 14:34:15", "2019-08-10 20:23:48");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Dan Brown", false, "2020-01-16 03:45:09", "2020-04-19 21:07:55");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Daphne du Maurier", true, "2019-01-12 08:36:09", "2020-05-22 16:36:42");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Truman Capote", true, "2019-12-08 02:51:49", "2019-08-11 00:41:26");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Mario Puzo, Robert Thompson", true, "2019-12-22 19:09:09", "2020-03-04 12:49:36");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Alice Sebold", true, "2019-07-12 21:13:18", "2020-06-17 18:03:14");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Umberto Eco, William Weaver", true, "2019-08-28 11:39:25", "2021-01-13 22:07:01");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Robin Waterfield", true, "2019-05-08 22:22:06", "2020-01-17 17:52:27");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Gillian Flynn", true, "2019-12-03 15:22:22", "2019-10-02 08:03:20");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Dennis Lehane", false, "2019-10-13 08:08:00", "2020-08-07 05:37:24");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Carlos Ruiz Zafï¿½n, Lucia Graves", true, "2019-10-14 11:55:56", "2020-08-01 00:58:09");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Caleb Carr", false, "2019-03-25 00:45:29", "2021-03-20 12:26:00");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Raymond Chandler", false, "2020-01-13 09:03:22", "2020-11-14 07:57:41");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Janet Evanovich", true, "2019-02-04 14:49:48", "2019-01-12 05:32:51");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Dashiell Hammett", true, "2019-12-26 12:38:58", "2019-01-25 17:21:40");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Thomas Harris", true, "2019-02-28 19:40:03", "2019-12-06 02:49:20");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Tana French", false, "2019-02-06 18:20:33", "2020-03-19 17:32:49");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Scott Turow", false, "2019-04-30 19:15:55", "2019-04-27 03:07:46");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Diane Setterfield", false, "2019-03-25 19:21:49", "2020-11-11 04:47:09");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Orson Scott Card, Stefan Rudnicki", true, "2019-07-03 22:46:15", "2020-01-06 12:12:52");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("George Orwell", false, "2019-01-04 04:47:47", "2020-09-24 01:46:11");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Ernest Cline", true, "2019-09-15 17:32:09", "2020-08-08 16:26:12");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Frank Herbert", false, "2019-06-15 14:51:53", "2019-08-13 11:44:24");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Ray Bradbury", true, "2019-11-16 02:26:05", "2019-10-05 10:16:51");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Andy Weir", false, "2019-08-07 15:17:48", "2019-12-09 12:35:34");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Philip K. Dick", false, "2019-04-23 07:02:41", "2021-04-09 14:37:02");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Suzanne Collins", false, "2019-07-14 09:21:21", "2020-07-03 03:59:01");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("H.G. Wells, Greg Bear", false, "2019-05-24 03:06:27", "2020-11-15 10:48:04");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Isaac Asimov", false, "2019-05-12 05:11:53", "2019-01-04 05:05:15");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Veronica Roth", true, "2019-12-14 15:27:12", "2021-03-14 02:58:40");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Robert A. Heinlein", false, "2019-11-25 16:21:30", "2021-01-13 15:56:21");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Margaret Atwood", false, "2019-04-30 01:30:02", "2019-07-18 00:24:20");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Douglas Adams", true, "2019-03-21 16:12:38", "2021-04-12 04:02:59");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Michael Crichton", false, "2019-12-19 00:43:13", "2020-10-16 18:44:26");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Arthur C. Clarke", false, "2019-11-26 15:33:50", "2019-10-11 17:50:22");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Will Wight", false, "2019-04-19 22:07:08", "2019-07-26 02:06:48");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Brent Weeks", true, "2020-01-15 14:23:54", "2020-11-28 14:18:46");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Brandon Sanderson", true, "2019-08-29 14:52:35", "2020-11-07 19:12:35");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Patrick Rothfuss", false, "2019-08-16 17:12:16", "2021-04-03 02:38:53");
insert into Authors
    (Name, Is_Removed, Date_Entered, Last_Modified)
values ("Benedict Jacka", true, "2019-04-11 13:34:51", "2021-01-08 19:40:42");

## Clients
insert into clients
(Hashed_Password, Is_Manager, First_Name, Last_Name, Company_Name, Address_1, Address_2, City, Province_Abbreviation, Country,
 Postal_Code, Home_Telephone, Cell_Telephone, Email, Date_Entered, Last_Modified, Is_Removed)
values ("placeholder12345!",false, "Germayne McGrady", "Dosi Castaner", "Oberbrunner LLC", "1875 Artisan Lane", null, "Banaba", 1,
        "Philippines", "4125", "3409310215", null, "dcastaner0@cbslocal.com", "2019-01-30 00:00:00",
        "2019-06-18 21:37:30", true);
insert into clients
(Hashed_Password, Is_Manager, First_Name, Last_Name, Company_Name, Address_1, Address_2, City, Province_Abbreviation, Country,
 Postal_Code, Home_Telephone, Cell_Telephone, Email, Date_Entered, Last_Modified, Is_Removed)
values ("placeholder12345!",true, "Carlene Fransemai", "Jane Hutcheon", "Rogahn, Barrows and Wehner", "27173 International Junction", null,
        "Amangarh", 2, "Pakistan", "24181", "5401036281", null, "jhutcheon1@last.fm", "2019-01-30 00:00:00",
        "2019-04-13 01:39:14", false);
insert into clients
(Hashed_Password, Is_Manager, First_Name, Last_Name, Company_Name, Address_1, Address_2, City, Province_Abbreviation, Country,
 Postal_Code, Home_Telephone, Cell_Telephone, Email, Date_Entered, Last_Modified, Is_Removed)
values ("placeholder12345!",true, "Micheline Salack", "Sibley Doud", "Cummerata, Green and Corkery", "115 Banding Drive", null, "Dalai", 3,
        "China", null, "5345304114", "1896606850", "sdoud2@liveinternet.ru", "2019-01-30 00:00:00",
        "2019-08-03 17:51:43", false);
insert into clients
(Hashed_Password, Is_Manager, First_Name, Last_Name, Company_Name, Address_1, Address_2, City, Province_Abbreviation, Country,
 Postal_Code, Home_Telephone, Cell_Telephone, Email, Date_Entered, Last_Modified, Is_Removed)
values ("placeholder12345!",false, "Emlen Chinnick", "Vernice Grigoli", "Rice, Hegmann and Gorczany", "1161 Loomis Plaza", null,
        "Pasirlimus", 4, "Indonesia", null, "5864802044", "6445467612", "vgrigoli3@github.com", "2019-01-30 00:00:00",
        "2019-08-13 01:38:24", true);
insert into clients
(Hashed_Password, Is_Manager, First_Name, Last_Name, Company_Name, Address_1, Address_2, City, Province_Abbreviation, Country,
 Postal_Code, Home_Telephone, Cell_Telephone, Email, Date_Entered, Last_Modified, Is_Removed)
values ("placeholder12345!",true, "Buddy Potapczuk", "Sonya Irlam", "O''Hara-Balistreri", "20554 Monterey Hill", null, "Lelekovice", 5,
        "Czech Republic", "664 31", "4927104394", "2407954166", "sirlam4@gravatar.com", "2019-01-30 00:00:00",
        "2019-11-16 12:27:26", true);
insert into clients
(Hashed_Password, Is_Manager, First_Name, Last_Name, Company_Name, Address_1, Address_2, City, Province_Abbreviation, Country,
 Postal_Code, Home_Telephone, Cell_Telephone, Email, Date_Entered, Last_Modified, Is_Removed)

values ("placeholder12345!",true, "Gardy Farnish", "Kippie Stonner", "Rice-Auer", "95313 Farragut Terrace", null, "Täby", 6, "Sweden",

        "183 60", "9607994610", "9609098477", "kstonner5@google.co.uk", "2019-01-30 00:00:00", "2020-01-04 10:45:11",
        true);
insert into clients
(Hashed_Password, Is_Manager, First_Name, Last_Name, Company_Name, Address_1, Address_2, City, Province_Abbreviation, Country,
 Postal_Code, Home_Telephone, Cell_Telephone, Email, Date_Entered, Last_Modified, Is_Removed)
values ("placeholder12345!",true, "Ave Heims", "Evonne Yearn", "Jenkins, Marvin and Heathcote", "30980 Morrow Drive", "57703",
        "Borodinskiy", 7, "Russia", "188961", "5643014039", "2404283838", "eyearn6@jiathis.com", "2019-01-30 00:00:00",
        "2019-08-07 07:21:32", true);
insert into clients
(Hashed_Password, Is_Manager, First_Name, Last_Name, Company_Name, Address_1, Address_2, City, Province_Abbreviation, Country,
 Postal_Code, Home_Telephone, Cell_Telephone, Email, Date_Entered, Last_Modified, Is_Removed)
values ("placeholder12345!",true, "Bertie Latan", "Dannie Basire", "Fahey LLC", "1 Cordelia Alley", null, "Sobreira", 8, "Portugal",
        "464545", "8404866499", "4031844525", "dbasire7@odnoklassniki.ru", "2019-01-30 00:00:00", "2019-11-19 12:23:30",
        false);
insert into clients
(Hashed_Password, Is_Manager, First_Name, Last_Name, Company_Name, Address_1, Address_2, City, Province_Abbreviation, Country,
 Postal_Code, Home_Telephone, Cell_Telephone, Email, Date_Entered, Last_Modified, Is_Removed)
values ("placeholder12345!",false, "Aland Brosel", "Morley Dolohunty", "Kohler Group", "8 Burning Wood Trail", null, "Hotsk", 9, "Belarus",
        null, "1192610936", null, "mdolohunty8@aboutads.info", "2019-01-30 00:00:00", "2019-09-29 02:08:47", true);
insert into clients
(Hashed_Password, Is_Manager, First_Name, Last_Name, Company_Name, Address_1, Address_2, City, Province_Abbreviation, Country,
 Postal_Code, Home_Telephone, Cell_Telephone, Email, Date_Entered, Last_Modified, Is_Removed)
values ("placeholder12345!",false, "Raynard Pirt", "Shayne Caccavella", "Goodwin-Crist", "152 Namekagon Junction", null, "Larvik", 10,
        "Norway", "3271", "1074788811", null, "scaccavella9@oakley.com", "2019-01-30 00:00:00", "2019-05-05 08:48:20",
        true);
insert into clients
(Hashed_Password, Is_Manager, First_Name, Last_Name, Company_Name, Address_1, Address_2, City, Province_Abbreviation, Country,
 Postal_Code, Home_Telephone, Cell_Telephone, Email, Date_Entered, Last_Modified, Is_Removed)
values ("placeholder12345!",true, "Aindrea Fobidge", "Rayna Leggin", "Ruecker-Schuppe", "27 Loeprich Way", "71605", "Caijiang", 11, "China",
        null, "2106855045", null, "rleggina@clickbank.net", "2019-01-30 00:00:00", "2019-03-18 12:02:57", false);
insert into clients
(Hashed_Password, Is_Manager, First_Name, Last_Name, Company_Name, Address_1, Address_2, City, Province_Abbreviation, Country,
 Postal_Code, Home_Telephone, Cell_Telephone, Email, Date_Entered, Last_Modified, Is_Removed)

values ("placeholder12345!",false, "Pace Mulchrone", "Daphna Stratz", "Thiel, Larkin and Zemlak", "45 Alpine Way", null, "Patitírion", 12,
        "Greece", null, "5375175146", "9737343634", "dstratzb@mac.com", "2019-01-30 00:00:00", "2020-01-28 19:25:13",
        false);
insert into clients
(Hashed_Password, Is_Manager, First_Name, Last_Name, Company_Name, Address_1, Address_2, City, Province_Abbreviation, Country,
 Postal_Code, Home_Telephone, Cell_Telephone, Email, Date_Entered, Last_Modified, Is_Removed)
values ("placeholder12345!",true, "Kerk Sheridan", "Carissa Hinrichsen", "Hilll and Sons", "75 Hoffman Circle", "52348", "Utama Wetan", 13,
        "Indonesia", null, "5737721134", "6663183047", "chinrichsenc@miitbeian.gov.cn", "2019-01-30 00:00:00",
        "2019-03-30 09:07:55", true);
insert into clients
(Hashed_Password, Is_Manager, First_Name, Last_Name, Company_Name, Address_1, Address_2, City, Province_Abbreviation, Country,
 Postal_Code, Home_Telephone, Cell_Telephone, Email, Date_Entered, Last_Modified, Is_Removed)

values ("placeholder12345!",true, "Loralie Crothers", "Ferris Chominski", "Spencer-Nikolaus", "0 Reindahl Avenue", null, "Pyhäntä", 14,
        "Finland", "92930", "3609732954", "9797858035", "fchominskid@google.co.jp", "2019-01-30 00:00:00",
        "2019-02-24 01:22:47", false);
insert into clients
(Hashed_Password, Is_Manager, First_Name, Last_Name, Company_Name, Address_1, Address_2, City, Province_Abbreviation, Country,
 Postal_Code, Home_Telephone, Cell_Telephone, Email, Date_Entered, Last_Modified, Is_Removed)
values ("placeholder12345!",true, "Saunder Niccolls", "Valida Skitteral", "Schamberger-Durgan", "4442 Commercial Plaza", "9437", "Blagaj",
        15, "Bosnia and Herzegovina", null, "1134862761", "5421953255", "vskitterale@jalbum.net", "2019-01-30 00:00:00",
        "2019-09-07 06:02:20", false);
insert into clients
(Hashed_Password, Is_Manager, First_Name, Last_Name, Company_Name, Address_1, Address_2, City, Province_Abbreviation, Country,
 Postal_Code, Home_Telephone, Cell_Telephone, Email, Date_Entered, Last_Modified, Is_Removed)
values ("placeholder12345!",true, "Josey Bracher", "Essa Warburton", "Hoppe Inc", "47921 Grover Lane", null, "Ljungby", 16, "Sweden",
        "341 23", "2323372131", "2275898829", "ewarburtonf@mtv.com", "2019-01-30 00:00:00", "2019-12-05 20:49:04",
        false);
insert into clients
(Hashed_Password, Is_Manager, First_Name, Last_Name, Company_Name, Address_1, Address_2, City, Province_Abbreviation, Country,
 Postal_Code, Home_Telephone, Cell_Telephone, Email, Date_Entered, Last_Modified, Is_Removed)
values ("placeholder12345!",false, "Ede Wing", "Denys Eastes", "Gleichner Inc", "67423 Pine View Lane", "0", "Saint Petersburg", 17,
        "United States", "33731", "7271237441", "2138184727", "deastesg@networksolutions.com", "2019-01-30 00:00:00",
        "2019-12-03 16:20:00", true);
insert into clients
(Hashed_Password, Is_Manager, First_Name, Last_Name, Company_Name, Address_1, Address_2, City, Province_Abbreviation, Country,
 Postal_Code, Home_Telephone, Cell_Telephone, Email, Date_Entered, Last_Modified, Is_Removed)
values ("placeholder12345!",true, "Westbrook Levitt", "Iorgo Montez", "Gusikowski-Wuckert", "95225 Mayer Road", null, "Ushuaia", 18,
        "Argentina", "9410", "7083191316", "5105286676", "imontezh@trellian.com", "2019-01-30 00:00:00",
        "2019-10-26 12:47:12", true);
insert into clients
(Hashed_Password, Is_Manager, First_Name, Last_Name, Company_Name, Address_1, Address_2, City, Province_Abbreviation, Country,
 Postal_Code, Home_Telephone, Cell_Telephone, Email, Date_Entered, Last_Modified, Is_Removed)
values ("placeholder12345!",true, "Fransisco Gligorijevic", "Lucky Vasey", "Auer LLC", "3151 Swallow Park", "16", "Ocongate", 19, "Peru",
        null, "6899621554", null, "lvaseyi@arizona.edu", "2019-01-30 00:00:00", "2019-07-05 12:09:24", true);
insert into clients
(Hashed_Password, Is_Manager, First_Name, Last_Name, Company_Name, Address_1, Address_2, City, Province_Abbreviation, Country,
 Postal_Code, Home_Telephone, Cell_Telephone, Email, Date_Entered, Last_Modified, Is_Removed)
values ("placeholder12345!",true, "Gretel Grassin", "Eugene Kubat", "Lemke-Kris", "37 Prentice Drive", null, "Xincun", 20, "China", null,
        "9871584227", "4682878331", "ekubatj@pen.io", "2019-01-30 00:00:00", "2020-01-10 07:36:13", true);
insert into clients
(Hashed_Password, Is_Manager, First_Name, Last_Name, Company_Name, Address_1, Address_2, City, Province_Abbreviation, Country,
 Postal_Code, Home_Telephone, Cell_Telephone, Email, Date_Entered, Last_Modified, Is_Removed)
values ("placeholder12345!",false, "Byrom Demangeon", "Mandi Heake", "Abshire Group", "2 Hoard Circle", "71717", "Serawai", 21, "Indonesia",
        null, "7792616559", "8849248757", "mheakek@epa.gov", "2019-01-30 00:00:00", "2019-03-08 00:29:20", false);
insert into clients
(Hashed_Password, Is_Manager, First_Name, Last_Name, Company_Name, Address_1, Address_2, City, Province_Abbreviation, Country,
 Postal_Code, Home_Telephone, Cell_Telephone, Email, Date_Entered, Last_Modified, Is_Removed)
values ("placeholder12345!",false, "Whit Bloxam", "Elaina Beavon", "Considine-Mayer", "6 Nova Circle", null, "Fontenay-sous-Bois", 22,
        "France", "9410", "1183870703", null, "ebeavonl@ycombinator.com", "2019-01-30 00:00:00", "2019-09-04 05:14:57",
        false);
insert into clients
(Hashed_Password, Is_Manager, First_Name, Last_Name, Company_Name, Address_1, Address_2, City, Province_Abbreviation, Country,
 Postal_Code, Home_Telephone, Cell_Telephone, Email, Date_Entered, Last_Modified, Is_Removed)
values ("placeholder12345!",false, "Haydon Ashford", "Andriette Brugman", "Bashirian, Hintz and Cruickshank", "0 Washington Crossing", null,
        "Viamão", 23, "Brazil", "944000", "9078415300", null, "abrugmanm@smh.com.au", "2019-01-30 00:00:00",

        "2019-11-13 23:58:44", true);
insert into clients
(Hashed_Password, Is_Manager, First_Name, Last_Name, Company_Name, Address_1, Address_2, City, Province_Abbreviation, Country,
 Postal_Code, Home_Telephone, Cell_Telephone, Email, Date_Entered, Last_Modified, Is_Removed)
values ("placeholder12345!",false, "Callean Imloch", "Brigg Wennington", "Gorczany, Romaguera and Bogan", "2279 Anderson Alley", null,
        "Doloplazy", 24, "Czech Republic", "783 56", "1059529794", null, "bwenningtonn@vistaprint.com",
        "2019-01-30 00:00:00", "2019-07-02 08:58:45", false);
insert into clients
(Hashed_Password, Is_Manager, First_Name, Last_Name, Company_Name, Address_1, Address_2, City, Province_Abbreviation, Country,
 Postal_Code, Home_Telephone, Cell_Telephone, Email, Date_Entered, Last_Modified, Is_Removed)
values ("placeholder12345!",false, "Dane Toye", "Celisse Bainton", "Predovic, Cummerata and Beer", "59 Farmco Terrace", "5", "Hidalgo", 25,
        "Mexico", "53580", "7511723274", "4468328350", "cbaintono@pbs.org", "2019-01-30 00:00:00",
        "2019-08-29 23:16:56", true);
insert into clients
(Hashed_Password, Is_Manager, First_Name, Last_Name, Company_Name, Address_1, Address_2, City, Province_Abbreviation, Country,
 Postal_Code, Home_Telephone, Cell_Telephone, Email, Date_Entered, Last_Modified, Is_Removed)
values ("placeholder12345!",true, "Lou Beavers", "Marni Arboin", "Dicki-Effertz", "20 Melody Road", null, "Wujiabao", 26, "China", null,
        "3013382811", "8317365586", "marboinp@nbcnews.com", "2019-01-30 00:00:00", "2020-01-28 21:56:43", true);
insert into clients
(Hashed_Password, Is_Manager, First_Name, Last_Name, Company_Name, Address_1, Address_2, City, Province_Abbreviation, Country,
 Postal_Code, Home_Telephone, Cell_Telephone, Email, Date_Entered, Last_Modified, Is_Removed)
values ("placeholder12345!",true, "Kerk Pestricke", "Angy Clemerson", "Hand, Barton and Homenick", "20788 Springview Park", null,
        "Saint Petersburg", 27, "Russia", "190990", "1551913157", "3947077258", "aclemersonq@fema.gov",
        "2019-01-30 00:00:00", "2019-04-29 02:12:55", false);
insert into clients
(Hashed_Password, Is_Manager, First_Name, Last_Name, Company_Name, Address_1, Address_2, City, Province_Abbreviation, Country,
 Postal_Code, Home_Telephone, Cell_Telephone, Email, Date_Entered, Last_Modified, Is_Removed)
values ("placeholder12345!",true, "Wilow Itzakson", "Federico Tsarovic", "Koss-Rath", "4 Miller Lane", "74427", "Sochaux", 28, "France",
        "25609", "9773075285", "9016709075", "ftsarovicr@berkeley.edu", "2019-01-30 00:00:00", "2019-10-29 05:24:44",
        false);
insert into clients
(Hashed_Password, Is_Manager, First_Name, Last_Name, Company_Name, Address_1, Address_2, City, Province_Abbreviation, Country,
 Postal_Code, Home_Telephone, Cell_Telephone, Email, Date_Entered, Last_Modified, Is_Removed)
values ("placeholder12345!",false, "Whitney Godball", "Jeana Nowlan", "Batz-Beatty", "44795 Pawling Way", null, "Duanjia", 29, "China",
        null, "9022046786", "3217090311", "jnowlans@ow.ly", "2019-01-30 00:00:00", "2019-10-18 14:24:18", false);
insert into clients
(Hashed_Password, Is_Manager, First_Name, Last_Name, Company_Name, Address_1, Address_2, City, Province_Abbreviation, Country,
 Postal_Code, Home_Telephone, Cell_Telephone, Email, Date_Entered, Last_Modified, Is_Removed)
values ("placeholder12345!",true, "Tabatha Iston", "Sawyer Gosling", "Pouros, Lynch and Tremblay", "7790 Utah Point", "353", "Duekoué", 30,

        "Ivory Coast", null, "8377915332", "5413296991", "sgoslingt@soundcloud.com", "2019-01-30 00:00:00",
        "2019-03-08 13:33:42", false);

## TAX
insert into tax
    (Province_Abbreviation, GST, PST, HST)
values ("AB", 0.05, 0.00, 0.00);
insert into tax
    (Province_Abbreviation, GST, PST, HST)
values ("BC", 0.05, 0.07, 0.00);
insert into tax
    (Province_Abbreviation, GST, PST, HST)
values ("MB", 0.05, 0.07, 0.00);
insert into tax
    (Province_Abbreviation, GST, PST, HST)
values ("NB", 0.00, 0.00, 0.15);
insert into tax
    (Province_Abbreviation, GST, PST, HST)
values ("NL", 0.00, 0.00, 0.15);
insert into tax
    (Province_Abbreviation, GST, PST, HST)
values ("NT", 0.05, 0.00, 0.00);
insert into tax
    (Province_Abbreviation, GST, PST, HST)
values ("NS", 0.00, 0.00, 0.15);
insert into tax
    (Province_Abbreviation, GST, PST, HST)
values ("NU", 0.05, 0.00, 0.00);
insert into tax
    (Province_Abbreviation, GST, PST, HST)
values ("ON", 0.00, 0.00, 0.13);
insert into tax
    (Province_Abbreviation, GST, PST, HST)
values ("PE", 0.00, 0.00, 0.13);
insert into tax
    (Province_Abbreviation, GST, PST, HST)
values ("QC", 0.05, 0.09975, 0.00);
insert into tax
    (Province_Abbreviation, GST, PST, HST)
values ("SK", 0.06, 0.05, 0.00);
insert into tax
    (Province_Abbreviation, GST, PST, HST)
values ("YT", 0.05, 0.00, 0.00);

INSERT INTO Book_Format
VALUES ("9780142000670", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780439244190", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780061120084", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780684830421", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780606323451", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780451526342", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780316769174", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780439023481", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780307277671", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9781594480003", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780140283334", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780679601685", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780062315007", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780770430078", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780375831003", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780307588371", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9781416524793", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780393970128", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780141439471", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780385603102", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780143039983", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780450040184", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780061007224", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9781416524342", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780450411434", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780380729401", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780345476876", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780735212510", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780450031069", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780307346605", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780727860996", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780062200570", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780061139376", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780671685638", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780345504968", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780062259660", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9781982110567", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780307949486", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780312330873", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780316323703", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780679745587", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780451205766", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780316166683", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780156001311", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780582418271", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780380731862", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780060584757", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780143034902", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780812976144", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780394758282", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780312362089", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780752865331", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780525945567", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780670038602", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780446350983", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780743298025", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780812550702", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780141036144", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780307887436", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780593099322", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9781451673319", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780804139021", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780553803716", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780439023498", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9781524796976", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780439023511", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780486284729", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780553803709", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780062024039", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780441788385", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780771008795", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9781509808335", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780345538987", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780451457998", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780989671767", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780989671774", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780989671781", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780999851104", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780999851111", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780999851128", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780999851135", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780316075558", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780316079914", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780316058964", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780316251334", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780316251303", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780765311788", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780765316882", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780765316899", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780765330420", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780765378552", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9781466862678", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780756404079", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780756404734", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9781937007294", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9781937007591", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9781937007720", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780425264928", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780425264942", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780425275757", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780698165083", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9781101988527", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780356507217", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);
INSERT INTO Book_Format
VALUES ("9780440000587", "E-Pub", "sample.epub", "2019-12-26 12:38:58", SYSDATE(), FALSE);


INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780142000670', '2017-01-08', '2017-02-08', FALSE, '9780142000670.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780439244190', '2018-09-02', '2018-10-02', TRUE, '9780439244190.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780061120084', '2019-05-23', '2019-05-23', FALSE, '9780061120084.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780684830421', '2018-09-04', '2018-10-04', FALSE, '9780684830421.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780606323451', '2019-06-26', '2019-07-26', FALSE, '9780606323451.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780451526342', '2017-04-01', '2017-05-01', FALSE, '9780451526342.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780316769174', '2018-01-30', '2018-01-30', FALSE, '9780316769174.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780439023481', '2019-09-14', '2019-09-14', FALSE, '9780439023481.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780307277671', '2017-03-28', '2017-03-28', FALSE, '9780307277671.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9781594480003', '2019-05-04', '2019-05-04', FALSE, '9781594480003.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780140283334', '2017-10-01', '2017-11-01', FALSE, '9780140283334.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780679601685', '2018-10-10', '2018-11-10', FALSE, '9780679601685.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780062315007', '2019-04-15', '2019-04-15', FALSE, '9780062315007.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780770430078', '2017-08-29', '2017-08-29', FALSE, '9780770430078.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780375831003', '2019-03-14', '2019-04-14', FALSE, '9780375831003.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780307588371', '2017-04-22', '2017-05-22', FALSE, '9780307588371.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9781416524793', '2018-04-01', '2018-04-01', FALSE, '9781416524793.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780393970128', '2019-05-12', '2019-05-12', FALSE, '9780393970128.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780141439471', '2017-06-25', '2017-07-25', FALSE, '9780141439471.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780385603102', '2018-03-07', '2018-04-07', TRUE, '9780385603102.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780143039983', '2019-11-28', '2019-12-28', FALSE, '9780143039983.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780450040184', '2017-07-01', '2017-08-01', FALSE, '9780450040184.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780061007224', '2018-02-01', '2018-03-01', FALSE, '9780061007224.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9781416524342', '2019-11-01', '2019-12-01', FALSE, '9781416524342.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780450411434', '2017-10-01', '2017-10-01', FALSE, '9780450411434.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780380729401', '2018-03-01', '2018-03-01', FALSE, '9780380729401.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780345476876', '2019-08-31', '2019-09-20', FALSE, '9780345476876.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780735212510', '2018-03-06', '2018-03-06', TRUE, '9780735212510.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780450031069', '2019-06-13', '2019-06-13', FALSE, '9780450031069.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780307346605', '2017-09-12', '2017-10-12', FALSE, '9780307346605.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780727860996', '2018-07-01', '2018-08-01', FALSE, '9780727860996.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780062200570', '2019-04-30', '2019-04-30', FALSE, '9780062200570.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780061139376', '2017-08-29', '2017-08-29', FALSE, '9780061139376.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780671685638', '2018-09-01', '2018-10-01', FALSE, '9780671685638.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780345504968', '2019-06-08', '2019-06-08', FALSE, '9780345504968.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780062259660', '2017-02-10', '2017-03-10', FALSE, '9780062259660.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9781982110567', '2019-09-10', '2019-09-10', FALSE, '9781982110567.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780307949486', '2017-09-16', '2017-10-16', FALSE, '9780307949486.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780312330873', '2018-05-03', '2019-05-03', FALSE, '9780312330873.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9781416524793', '2019-04-01', '2019-04-01', FALSE, '9781416524793.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780316323703', '2017-12-17', '2019-12-17', TRUE, '9780316323703.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780679745587', '2018-06-16', '2019-06-16', FALSE, '9780679745587.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780451205766', '2019-03-01', '2019-03-01', FALSE, '9780451205766.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780316166683', '2017-09-01', '2019-09-01', FALSE, '9780316166683.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780156001311', '2018-09-28', '2019-09-28', FALSE, '9780156001311.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780582418271', '2019-02-15', '2019-02-15', FALSE, '9780582418271.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780380731862', '2017-04-27', '2019-04-27', FALSE, '9780380731862.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780307588371', '2018-04-22', '2019-04-22', FALSE, '9780307588371.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780060584757', '2019-02-01', '2019-02-01', FALSE, '9780060584757.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780143034902', '2017-01-25', '2019-01-25', FALSE, '9780143034902.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780812976144', '2018-10-24', '2019-10-24', FALSE, '9780812976144.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780394758282', '2019-07-12', '2019-07-12', FALSE, '9780394758282.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780312362089', '2017-06-28', '2019-06-28', FALSE, '9780312362089.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780752865331', '2018-03-01', '2019-03-01', FALSE, '9780752865331.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780525945567', '2019-03-22', '2019-03-22', TRUE, '9780525945567.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780670038602', '2017-03-17', '2019-03-17', FALSE, '9780670038602.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780446350983', '2018-06-10', '2019-06-10', FALSE, '9780446350983.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780743298025', '2019-11-12', '2019-11-12', FALSE, '9780743298025.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780812550702', '2017-09-30', '2017-09-30', FALSE, '9780812550702.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780439023481', '2018-09-14', '2019-09-14', FALSE, '9780439023481.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780141036144', '2019-09-03', '2019-09-03', FALSE, '9780141036144.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780307887436', '2017-08-16', '2019-08-16', FALSE, '9780307887436.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780593099322', '2018-10-01', '2019-10-01', FALSE, '9780593099322.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9781451673319', '2019-11-29', '2019-11-29', FALSE, '9781451673319.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780439023481', '2017-09-14', '2019-09-14', FALSE, '9780439023481.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780804139021', '2018-02-11', '2019-02-11', FALSE, '9780804139021.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780553803716', '2019-06-01', '2019-06-01', FALSE, '9780553803716.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780439023498', '2017-09-01', '2019-09-01', TRUE, '9780439023498.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9781524796976', '2018-02-26', '2019-02-26', FALSE, '9781524796976.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780439023511', '2019-08-24', '2019-08-24', FALSE, '9780439023511.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780486284729', '2017-10-01', '2019-10-01', FALSE, '978-0486284729.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780553803709', '2018-06-01', '2019-06-01', FALSE, '9780553803709.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780062024039', '2019-02-28', '2019-02-28', TRUE, '9780062024039.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780441788385', '2017-10-01', '2019-10-01', FALSE, '9780441788385.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780771008795', '2018-04-04', '2019-04-04', TRUE, '9780771008795.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9781509808335', '2019-04-26', '2019-04-26', FALSE, '9781509808335.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780345538987', '2017-05-14', '2017-05-14', FALSE, '9780345538987.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780451457998', '2018-09-01', '2019-09-01', FALSE, '9780451457998.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780989671767', '2019-06-13', '2019-06-13', FALSE, '9780989671767.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780989671774', '2017-09-26', '2017-09-26', FALSE, '9780989671774.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780989671781', '2017-04-30', '2017-04-30', FALSE, '9780989671781.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780999851104', '2017-09-30', '2017-09-30', FALSE, '9780999851104.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780999851111', '2018-05-31', '2018-05-31', FALSE, '9780999851111.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780999851128', '2019-03-01', '2019-03-01', FALSE, '9780999851128.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780999851135', '2019-09-26', '2019-09-26', FALSE, '9780999851135.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780316075558', '2017-08-25', '2017-08-25', FALSE, '9780316075558.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780316079914', '2018-09-11', '2018-09-11', FALSE, '9780316079914.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780316058964', '2019-08-26', '2019-08-26', FALSE, '9780316058964.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780316251334', '2017-10-25', '2017-10-25', FALSE, '9780316251334.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780316251303', '2019-10-22', '2019-10-22', FALSE, '9780316251303.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780765311788', '2017-06-25', '2017-06-25', FALSE, '9780765311788.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780765316882', '2017-08-21', '2017-08-21', FALSE, '9780765316882.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780765316899', '2018-10-14', '2018-10-14', FALSE, '9780765316899.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780765330420', '2019-11-08', '2019-11-08', FALSE, '9780765330420.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780765378552', '2017-10-06', '2017-10-06', FALSE, '9780765378552.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9781466862678', '2018-01-26', '2019-01-26', FALSE, '9781466862678.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780756404079', '2019-04-07', '2019-04-07', FALSE, '9780756404079.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780756404734', '2017-03-01', '2019-03-01', FALSE, '9780756404734.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9781937007294', '2018-02-28', '2019-02-28', FALSE, '9781937007294.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9781937007591', '2019-05-29', '2019-05-29', FALSE, '9781937007591.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9781937007720', '2017-08-28', '2019-08-28', FALSE, '9781937007720.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780425264928', '2018-08-27', '2019-08-27', FALSE, '9780425264928.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780425264942', '2019-09-02', '2019-09-02', FALSE, '9780425264942.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780425275757', '2017-08-04', '2019-08-04', FALSE, '9780425275757.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780698165083', '2018-04-07', '2019-04-07', FALSE, '9780698165083.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9781101988527', '2017-04-04', '2019-04-04', FALSE, '9781101988527.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780356507217', '2018-06-05', '2019-06-05', FALSE, '9780356507217.pdf');
INSERT INTO Book_Format(ISBN, date_created, last_modified, Is_Removed, File_Location)
VALUES ('9780440000587', '2019-09-24', '2019-09-24', FALSE, '9780440000587.pdf');

INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780142000670','2017-01-08','2017-02-08',FALSE,'9780142000670.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780439244190','2018-09-02','2018-10-02',TRUE,'9780439244190.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780061120084','2019-05-23','2019-05-23',FALSE,'9780061120084.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9781328869333','2017-09-03','2017-10-03',FALSE,'9781328869333.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780684830421','2018-09-04','2018-10-04',FALSE,'9780684830421.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780606323451','2019-06-26','2019-07-26',FALSE,'9780606323451.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780451526342','2017-04-01','2017-05-01',FALSE,'9780451526342.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780316769174','2018-01-30','2018-01-30',FALSE,'9780316769174.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780439023481','2019-09-14','2019-09-14',FALSE,'9780439023481.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780307277671','2017-03-28','2017-03-28',FALSE,'9780307277671.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780385490818','2018-04-01','2018-05-01',TRUE,'9780385490818.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9781594480003','2019-05-04','2019-05-04',FALSE,'9781594480003.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780140283334','2017-10-01','2017-11-01',FALSE,'9780140283334.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780679601685','2018-10-10','2018-11-10',FALSE,'9780679601685.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780062315007','2019-04-15','2019-04-15',FALSE,'9780062315007.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780770430078','2017-08-29','2017-08-29',FALSE,'9780770430078.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9781451690316','2018-11-29','2018-11-29',FALSE,'9781451690316.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780375831003','2019-03-14','2019-04-14',FALSE,'9780375831003.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780307588371','2017-04-22','2017-05-22',FALSE,'9780307588371.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9781416524793','2018-04-01','2018-04-01',FALSE,'9781416524793.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780393970128','2019-05-12','2019-05-12',FALSE,'9780393970128.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780141439471','2017-06-25','2017-07-25',FALSE,'9780141439471.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780385603102','2018-03-07','2018-04-07',TRUE,'9780385603102.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780143039983','2019-11-28','2019-12-28',FALSE,'9780143039983.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780450040184','2017-07-01','2017-08-01',FALSE,'9780450040184.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780061007224','2018-02-01','2018-03-01',FALSE,'9780061007224.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9781416524342','2019-11-01','2019-12-01',FALSE,'9781416524342.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780450411434','2017-10-01','2017-10-01',FALSE,'9780450411434.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780380729401','2018-03-01','2018-03-01',FALSE,'9780380729401.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780345476876','2019-08-31','2019-09-20',FALSE,'9780345476876.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780735212510','2018-03-06','2018-03-06',TRUE,'9780735212510.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780450031069','2019-06-13','2019-06-13',FALSE,'9780450031069.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780307346605','2017-09-12','2017-10-12',FALSE,'9780307346605.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780727860996','2018-07-01','2018-08-01',FALSE,'9780727860996.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780062200570','2019-04-30','2019-04-30',FALSE,'9780062200570.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780061139376','2017-08-29','2017-08-29',FALSE,'9780061139376.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780671685638','2018-09-01','2018-10-01',FALSE,'9780671685638.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780345504968','2019-06-08','2019-06-08',FALSE,'9780345504968.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780062259660','2017-02-10','2017-03-10',FALSE,'9780062259660.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9781982110567','2019-09-10','2019-09-10',FALSE,'9781982110567.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780307949486','2017-09-16','2017-10-16',FALSE,'9780307949486.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780312330873','2018-05-03','2019-05-03',FALSE,'9780312330873.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9781416524793','2019-04-01','2019-04-01',FALSE,'9781416524793.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780316323703','2017-12-17','2019-12-17',TRUE,'9780316323703.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780679745587','2018-06-16','2019-06-16',FALSE,'9780679745587.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780451205766','2019-03-01','2019-03-01',FALSE,'9780451205766.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780316166683','2017-09-01','2019-09-01',FALSE,'9780316166683.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780156001311','2018-09-28','2019-09-28',FALSE,'9780156001311.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780582418271','2019-02-15','2019-02-15',FALSE,'9780582418271.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780380731862','2017-04-27','2019-04-27',FALSE,'9780380731862.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780307588371','2018-04-22','2019-04-22',FALSE,'9780307588371.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780060584757','2019-02-01','2019-02-01',FALSE,'9780060584757.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780143034902','2017-01-25','2019-01-25',FALSE,'9780143034902.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780812976144','2018-10-24','2019-10-24',FALSE,'9780812976144.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780394758282','2019-07-12','2019-07-12',FALSE,'9780394758282.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780312362089','2017-06-28','2019-06-28',FALSE,'9780312362089.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780752865331','2018-03-01','2019-03-01',FALSE,'9780752865331.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780525945567','2019-03-22','2019-03-22',TRUE,'9780525945567.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780670038602','2017-03-17','2019-03-17',FALSE,'9780670038602.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780446350983','2018-06-10','2019-06-10',FALSE,'9780446350983.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780743298025','2019-11-12','2019-11-12',FALSE,'9780743298025.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780812550702','2017-09-30','2017-09-30',FALSE,'9780812550702.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780439023481','2018-09-14','2019-09-14',FALSE,'9780439023481.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780141036144','2019-09-03','2019-09-03',FALSE,'9780141036144.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780307887436','2017-08-16','2019-08-16',FALSE,'9780307887436.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780593099322','2018-10-01','2019-10-01',FALSE,'9780593099322.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9781451673319','2019-11-29','2019-11-29',FALSE,'9781451673319.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780439023481','2017-09-14','2019-09-14',FALSE,'9780439023481.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780804139021','2018-02-11','2019-02-11',FALSE,'9780804139021.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780553803716','2019-06-01','2019-06-01',FALSE,'9780553803716.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780439023498','2017-09-01','2019-09-01',TRUE,'9780439023498.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9781524796976','2018-02-26','2019-02-26',FALSE,'9781524796976.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780439023511','2019-08-24','2019-08-24',FALSE,'9780439023511.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780486284729','2017-10-01','2019-10-01',FALSE,'978-0486284729.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780553803709','2018-06-01','2019-06-01',FALSE,'9780553803709.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780062024039','2019-02-28','2019-02-28',TRUE,'9780062024039.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780441788385','2017-10-01','2019-10-01',FALSE,'9780441788385.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780771008795','2018-04-04','2019-04-04',TRUE,'9780771008795.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9781509808335','2019-04-26','2019-04-26',FALSE,'9781509808335.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780345538987','2017-05-14','2017-05-14',FALSE,'9780345538987.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780451457998','2018-09-01','2019-09-01',FALSE,'9780451457998.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780989671767','2019-06-13','2019-06-13',FALSE,'9780989671767.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780989671774','2017-09-26','2017-09-26',FALSE,'9780989671774.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780989671781','2017-04-30','2017-04-30',FALSE,'9780989671781.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780999851104','2017-09-30','2017-09-30',FALSE,'9780999851104.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780999851111','2018-05-31','2018-05-31',FALSE,'9780999851111.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780999851128','2019-03-01','2019-03-01',FALSE,'9780999851128.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780999851135','2019-09-26','2019-09-26',FALSE,'9780999851135.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780316075558','2017-08-25','2017-08-25',FALSE,'9780316075558.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780316079914','2018-09-11','2018-09-11',FALSE,'9780316079914.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780316058964','2019-08-26','2019-08-26',FALSE,'9780316058964.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780316251334','2017-10-25','2017-10-25',FALSE,'9780316251334.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780316251303','2019-10-22','2019-10-22',FALSE,'9780316251303.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780765311788','2017-06-25','2017-06-25',FALSE,'9780765311788.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780765316882','2017-08-21','2017-08-21',FALSE,'9780765316882.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780765316899','2018-10-14','2018-10-14',FALSE,'9780765316899.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780765330420','2019-11-08','2019-11-08',FALSE,'9780765330420.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780765378552','2017-10-06','2017-10-06',FALSE,'9780765378552.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9781466862678','2018-01-26','2019-01-26',FALSE,'9781466862678.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780756404079','2019-04-07','2019-04-07',FALSE,'9780756404079.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780756404734','2017-03-01','2019-03-01',FALSE,'9780756404734.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9781937007294','2018-02-28','2019-02-28',FALSE,'9781937007294.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9781937007591','2019-05-29','2019-05-29',FALSE,'9781937007591.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9781937007720','2017-08-28','2019-08-28',FALSE,'9781937007720.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780425264928','2018-08-27','2019-08-27',FALSE,'9780425264928.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780425264942','2019-09-02','2019-09-02',FALSE,'9780425264942.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780425275757','2017-08-04','2019-08-04',FALSE,'9780425275757.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780698165083','2018-04-07','2019-04-07',FALSE,'9780698165083.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9781101988527','2017-04-04','2019-04-04',FALSE,'9781101988527.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780356507217','2018-06-05','2019-06-05',FALSE,'9780356507217.pdf','pdf');
INSERT INTO Book_Format(ISBN,Date_Created,Last_Modified,Is_Removed,File_Location,Format) VALUES ('9780440000587','2019-09-24','2019-09-24',FALSE,'9780440000587.pdf','pdf');
INSERT INTO News (RSS_Feed,Date_Created,Date_Ended,Is_Removed,Last_Modified) VALUES('http://xkcd.com/atom.xml','2019-05-01',NULL,FALSE,'2019-05-01');
INSERT INTO News (RSS_Feed,Date_Created,Date_Ended,Is_Removed,Last_Modified) VALUES('http://feeds.feedburner.com/CssTricks','2019-06-01',NULL,FALSE,'2019-07-01');
INSERT INTO News (RSS_Feed,Date_Created,Date_Ended,Is_Removed,Last_Modified) VALUES('http://rss.slashdot.org/Slashdot/slashdot','2019-07-01',NULL,FALSE,'2019-08-01');
INSERT INTO News (RSS_Feed,Date_Created,Date_Ended,Is_Removed,Last_Modified) VALUES('http://feeds.mashable.com/Mashable','2019-05-01',NULL,FALSE,'2019-08-01');
INSERT INTO News (RSS_Feed,Date_Created,Date_Ended,Is_Removed,Last_Modified) VALUES('http://www.theverge.com/rss/index.xml','2020-01-01','2019-02-01',TRUE,'2019-02-01');
INSERT INTO News (RSS_Feed,Date_Created,Date_Ended,Is_Removed,Last_Modified) VALUES('http://feeds.macrumors.com/MacRumors-All','2020-01-01','2020-01-02',TRUE,'2020-01-02');
INSERT INTO Ads (Image_Name,Ad_Url,Date_Created,Last_Modified,Is_Removed) VALUES('banana.jpg','https://en.wikipedia.org/wiki/Banana','2019-05-01','2019-05-01',FALSE);
INSERT INTO Ads (Image_Name,Ad_Url,Date_Created,Last_Modified,Is_Removed) VALUES('apple.jpg','https://en.wikipedia.org/wiki/Apple','2019-05-01','2019-05-01',FALSE);
INSERT INTO Ads (Image_Name,Ad_Url,Date_Created,Last_Modified,Is_Removed) VALUES('pineapple.jpg','https://en.wikipedia.org/wiki/Pineapple','2019-06-01','2019-07-01',FALSE);
INSERT INTO Ads (Image_Name,Ad_Url,Date_Created,Last_Modified,Is_Removed) VALUES('melon.jpg','https://en.wikipedia.org/wiki/Melon','2019-06-01','2019-08-01',FALSE);
INSERT INTO Ads (Image_Name,Ad_Url,Date_Created,Last_Modified,Is_Removed) VALUES('blueberry.jpg','https://en.wikipedia.org/wiki/Blueberry','2019-07-01','2019-09-01',FALSE);

INSERT INTO Ads (Image_Name,Ad_Url,Date_Created,Last_Modified,Is_Removed) VALUES('grapefruit.jpg','https://en.wikipedia.org/wiki/Grapefruit','2019-08-01','2019-10-01',TRUE);
INSERT INTO Surveys (Survey_Name,Date_Created,Last_Modified,Is_Removed,Survey_Description)
    VALUES('Do you like to read?','2019-06-01','2019-06-01',FALSE,'Here at TheBookStore we would like to ask our community what their opinion on reading is, positive, negative, or something else');
INSERT INTO Surveys (Survey_Name,Date_Created,Last_Modified,Is_Removed,Survey_Description)
    VALUES('What is your favorite year in history','2019-07-01','2019-07-01',FALSE,'Here at TheBookStore we are interested in the opinion of our audience on contemporary history, in particular we want your opinion on our selection of the juciest recent years.');
INSERT INTO Surveys (Survey_Name,Date_Created,Last_Modified,Is_Removed,Survey_Description)
    VALUES('Is Shakespeare overrated?','2019-08-01','2019-09-01',FALSE,'Here at TheBookStore we ask the buring questions we suppose are on everyones mind. Shakespeare brilliant artist or overrated hack? You decide.');
INSERT INTO Surveys (Survey_Name,Date_Created,Last_Modified,Is_Removed,Survey_Description)
    VALUES('What is your opinion on Trains','2019-09-01','2019-09-01',FALSE,'Trains some people obesess over them, others could not care less. Where do you fall?');
INSERT INTO Surveys (Survey_Name,Date_Created,Last_Modified,Is_Removed,Survey_Description)
    VALUES('Should we ban the word however?','2019-10-01','2019-10-01',FALSE,'We at TheBookstore would argue the word however has been overused and abused in too many school essays and should never see the light of day again, however it could be argued it has a place in mature literature. You decide its fate.');
INSERT INTO Surveys (Survey_Name,Date_Created,Last_Modified,Is_Removed,Survey_Description)
    VALUES('Would you survive a zombie apocalipse?','2019-011-01','2019-012-01',FALSE,'The real questions right now. In light of all you know about zombies from countless educational sources would you survive a zombie apocalipse and why?');
INSERT INTO Survey_Data (Is_Removed,Survey_ID,Votes,Date_Created,Last_Modified,Choice)
    VALUES(FALSE,1,10,'2019-06-01','2019-06-01','Yes');
INSERT INTO Survey_Data (Is_Removed,Survey_ID,Votes,Date_Created,Last_Modified,Choice)
    VALUES(FALSE,1,20,'2019-06-01','2019-06-01','No');
INSERT INTO Survey_Data (Is_Removed,Survey_ID,Votes,Date_Created,Last_Modified,Choice)
    VALUES(FALSE,1,5,'2019-06-01','2019-06-01','Sometimes');
INSERT INTO Survey_Data (Is_Removed,Survey_ID,Votes,Date_Created,Last_Modified,Choice)
    VALUES(FALSE,1,2,'2019-06-01','2019-06-01','Only morally questionable material.');
INSERT INTO Survey_Data (Is_Removed,Survey_ID,Votes,Date_Created,Last_Modified,Choice)
    VALUES(FALSE,1,1,'2019-06-01','2019-06-01','Actually I am illiterate, someone helped me vote here');
INSERT INTO Survey_Data (Is_Removed,Survey_ID,Votes,Date_Created,Last_Modified,Choice)
    VALUES(FALSE,2,10,'2019-07-01','2019-07-01','1984');
INSERT INTO Survey_Data (Is_Removed,Survey_ID,Votes,Date_Created,Last_Modified,Choice)
    VALUES(FALSE,2,15,'2019-07-01','2019-07-01','1999');
INSERT INTO Survey_Data (Is_Removed,Survey_ID,Votes,Date_Created,Last_Modified,Choice)
    VALUES(FALSE,2,20,'2019-07-01','2019-07-01','2000');
INSERT INTO Survey_Data (Is_Removed,Survey_ID,Votes,Date_Created,Last_Modified,Choice)
    VALUES(FALSE,2,15,'2019-07-01','2019-07-01','2008');
INSERT INTO Survey_Data (Is_Removed,Survey_ID,Votes,Date_Created,Last_Modified,Choice)
    VALUES(FALSE,2,5,'2019-07-01','2019-07-01','2020');
INSERT INTO Survey_Data (Is_Removed,Survey_ID,Votes,Date_Created,Last_Modified,Choice)
    VALUES(FALSE,2,3,'2019-07-01','2019-07-01','3000 (I think I am funny)');
INSERT INTO Survey_Data (Is_Removed,Survey_ID,Votes,Date_Created,Last_Modified,Choice)
    VALUES(FALSE,3,10,'2019-08-01','2019-08-01','Yes');
INSERT INTO Survey_Data (Is_Removed,Survey_ID,Votes,Date_Created,Last_Modified,Choice)
    VALUES(FALSE,3,20,'2019-08-01','2019-08-01','No');
INSERT INTO Survey_Data (Is_Removed,Survey_ID,Votes,Date_Created,Last_Modified,Choice)
    VALUES(FALSE,3,5,'2019-08-01','2019-08-01','Who is Sakespeare?');
INSERT INTO Survey_Data (Is_Removed,Survey_ID,Votes,Date_Created,Last_Modified,Choice)
    VALUES(FALSE,3,2,'2019-08-01','2019-10-01','I feel we really first need to properly define overrated');
INSERT INTO Survey_Data (Is_Removed,Survey_ID,Votes,Date_Created,Last_Modified,Choice)
    VALUES(FALSE,4,10,'2019-09-01','2019-09-01','Trains are justice');
INSERT INTO Survey_Data (Is_Removed,Survey_ID,Votes,Date_Created,Last_Modified,Choice)
    VALUES(FALSE,4,15,'2019-09-01','2019-09-01','Dude, they are just machines');
INSERT INTO Survey_Data (Is_Removed,Survey_ID,Votes,Date_Created,Last_Modified,Choice)
    VALUES(FALSE,4,2,'2019-09-01','2019-09-01','I build and design trains, so they are important to me.');
INSERT INTO Survey_Data (Is_Removed,Survey_ID,Votes,Date_Created,Last_Modified,Choice)
    VALUES(FALSE,4,1,'2019-09-01','2019-10-01','I live in 1910, so they are my best form of transportation.');
INSERT INTO Survey_Data (Is_Removed,Survey_ID,Votes,Date_Created,Last_Modified,Choice)
    VALUES(FALSE,5,25,'2019-10-01','2019-10-01','Dear god yes.');
INSERT INTO Survey_Data (Is_Removed,Survey_ID,Votes,Date_Created,Last_Modified,Choice)
    VALUES(FALSE,5,10,'2019-10-01','2019-10-01','No! It is my favorite word, however I understand where you are coming from.');
INSERT INTO Survey_Data (Is_Removed,Survey_ID,Votes,Date_Created,Last_Modified,Choice)
    VALUES(FALSE,5,15,'2019-10-01','2019-10-01','I am sorry, but this is stupid, who cares?');
INSERT INTO Survey_Data (Is_Removed,Survey_ID,Votes,Date_Created,Last_Modified,Choice)
    VALUES(FALSE,5,5,'2019-10-01','2019-10-02','However, however, however, however, however....');
INSERT INTO Survey_Data (Is_Removed,Survey_ID,Votes,Date_Created,Last_Modified,Choice)
    VALUES(FALSE,6,10,'2019-11-01','2019-11-01','I think so, yeah.');
INSERT INTO Survey_Data (Is_Removed,Survey_ID,Votes,Date_Created,Last_Modified,Choice)
    VALUES(FALSE,6,20,'2019-11-01','2019-11-01','Are you kidding, I have trained for this my whole life.');
INSERT INTO Survey_Data (Is_Removed,Survey_ID,Votes,Date_Created,Last_Modified,Choice)
    VALUES(FALSE,6,5,'2019-11-01','2019-11-01','Honestly, no, probably not.');
INSERT INTO Survey_Data (Is_Removed,Survey_ID,Votes,Date_Created,Last_Modified,Choice)
    VALUES(FALSE,6,2,'2019-11-01','2019-11-01','Two words: plot armour.');
INSERT INTO Survey_Data (Is_Removed,Survey_ID,Votes,Date_Created,Last_Modified,Choice)
    VALUES(FALSE,6,5,'2019-11-01','2019-11-01','You do know zombies are not real right?');
INSERT INTO Survey_Data (Is_Removed,Survey_ID,Votes,Date_Created,Last_Modified,Choice)
    VALUES(FALSE,6,1,'2019-11-01','2019-11-01','I will be fine, as I will be on mars.');
