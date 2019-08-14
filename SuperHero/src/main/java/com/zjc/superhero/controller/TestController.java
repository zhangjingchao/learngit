package com.zjc.superhero.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zjc.superhero.model.Test;

import lombok.Data;

@Controller
public class TestController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/test")
	@ResponseBody
	public String dealTest(@RequestParam(value = "name", defaultValue = "World") String name) {
		//return new Test(counter.incrementAndGet(), String.format(template, name));
		return "ok";
	}

	@RequestMapping("/test1")
	@ResponseBody
	public Test dealTest1(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Test(counter.incrementAndGet(), String.format(template, name));
	}
	
	/**
     * HOMEの初期処理
     * 
     * @param locale 位置
     * @param model モデル
     */
    @GetMapping(value = "/index/Carousel")
    @ResponseBody
    public Carousel getCarousel() {

        return setCarouselData().get(0);
    }

    @Data
    @JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
    class Carousel implements Serializable {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		String id;
        String name;
        String poster;
        String cover;
        String trailer;
        double score;
        int prisedCounts;
        String basicInfo;
        String originalName;
        String releaseDate;
        String totalTime;
        String plotDesc;
        String directors;
        List<String> actors= new  ArrayList<String>();
        List<String> plotPics= new  ArrayList<String>();
        String createTime;
    }

    private List<Carousel> setCarouselData() {
        List<Carousel> carouselList = new ArrayList<Carousel>();
        Carousel carouselTmp = new Carousel();
        carouselTmp.id = "dc-1004";
        carouselTmp.name = "蝙蝠侠:黑暗骑士崛起";
        carouselTmp.poster = "http://122.152.205.72:88/superhero/DC/BatManTheDarkKnightRises/poster.jpg";
        carouselTmp.cover = "http://122.152.205.72:88/superhero/DC/BatManTheDarkKnightRises/cover.jpg";
        carouselTmp.trailer = "http://122.152.205.72:88/superhero/DC/BatManTheDarkKnightRises/trailer.mp4";
        carouselTmp.score = 9.1;
        carouselTmp.prisedCounts = 7561;
        carouselTmp.basicInfo = "2018 / 美国 / 科幻 / 超级英雄";
        carouselTmp.originalName = "原名：The Dark Knight‎ Rises ";
        carouselTmp.releaseDate = "上映时间：2012-08-27(中国大陆)";
        carouselTmp.totalTime = "影片时长：165分钟(中国大陆)";
        carouselTmp.plotDesc =
                "检察官哈维·登特（艾伦·艾克哈特 Aaron Eckhart 饰）死后的八年间，哥谭市在戈登警长（加里·奥德曼 Gary Oldman 饰）的努力下有效地遏制了犯罪活动。而蝙蝠侠布鲁斯·韦恩（克里斯蒂安·贝尔 Christian Bale 饰）因为背负谋杀登特的罪名，被 警方通缉，在哥谭市销声匿迹。然而，这看似平静的状态被恐怖分子贝恩（汤姆·哈迪 Tom Hardy 饰）的出现打破，他利用猫女（安妮·海瑟薇 Anne Hathaway 饰）偷取布鲁斯的指纹，致使韦恩集团面临破财，布鲁斯被赶出董事会。为了保证韦恩集团投资的能源项目不被坏人利用制造核弹，布鲁斯帮助米兰达（玛丽昂·歌迪亚 Marion Cotillard 饰）成为董事会主席。贝恩接下来一连串精密设计的计划将哥谭市陷入孤绝之境，毁灭之日指日可待。布鲁斯只能再次肩负起拯救哥谭的重任，然而至亲的管家阿福辞职离开、猫女的背叛、贝恩的凶残手段，爱人米拉达的真实面目露出，都让他拯救哥谭的行动变得不可能…";
        carouselTmp.directors = "";
        carouselTmp.actors.add("");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/DC/BatManTheDarkKnightRises/photos/1.jpg");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/DC/BatManTheDarkKnightRises/photos/2.jpg");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/DC/BatManTheDarkKnightRises/photos/3.jpg");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/DC/BatManTheDarkKnightRises/photos/4.jpg");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/DC/BatManTheDarkKnightRises/photos/5.jpg");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/DC/BatManTheDarkKnightRises/photos/6.jpg");
        carouselTmp.createTime = "2012-08-27T07:40:37.000+0000";
        carouselList.add(carouselTmp);

        carouselTmp = new Carousel();
        carouselTmp.id = "marvel-1026";
        carouselTmp.name = "毒液：致命守护者";
        carouselTmp.poster = "http://122.152.205.72:88/superhero/MARVEL/Venom/poster.png";
        carouselTmp.cover = "http://122.152.205.72:88/superhero/MARVEL/Venom/cover.png";
        carouselTmp.trailer = "http://122.152.205.72:88/superhero/MARVEL/Venom/trailer.mp4";
        carouselTmp.score = 8.9;
        carouselTmp.prisedCounts = 7892;
        carouselTmp.basicInfo = "2018 / 美国 / 科幻 / 超级英雄";
        carouselTmp.originalName = "原名：Venom";
        carouselTmp.releaseDate = "上映时间：2018-11-09(中国大陆)";
        carouselTmp.totalTime = "影片时长：112分钟";
        carouselTmp.plotDesc =
                "艾迪（汤姆·哈迪 Tom Hardy 饰）是一位深受观众喜爱的新闻记者，和女友安妮（米歇尔·威廉姆斯 Michelle Williams 饰）相恋多年，彼此之间感情十分要好。安妮是一名律师，接手了生命基金会的案件，在女友的邮箱里，艾迪发现了基金会老板德雷克（里兹·阿迈德 Riz Ahmed 饰）不为人知的秘密。为此，艾迪不仅丢了工作，女友也离他而去";
        carouselTmp.directors = "";
        carouselTmp.actors.add("");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/MARVEL/Venom/photos/1.png");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/MARVEL/Venom/photos/2.png");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/MARVEL/Venom/photos/3.png");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/MARVEL/Venom/photos/4.png");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/MARVEL/Venom/photos/5.png");
        carouselTmp.createTime = "2018-11-09T07:40:37.000+0000";
        carouselList.add(carouselTmp);

        carouselTmp = new Carousel();
        carouselTmp.id = "marvel-1005";
        carouselTmp.name = "复仇者联盟3：无限战争";
        carouselTmp.poster = "http://122.152.205.72:88/superhero/MARVEL/Avengers3/poster.png";
        carouselTmp.cover = "http://122.152.205.72:88/superhero/MARVEL/Avengers3/cover.png";
        carouselTmp.trailer = "http://122.152.205.72:88/superhero/MARVEL/Avengers3/trailer.mp4";
        carouselTmp.score = 8.8;
        carouselTmp.prisedCounts = 9637;
        carouselTmp.basicInfo = "2018 / 美国 / 科幻 / 超级英雄";
        carouselTmp.originalName = "原名：Avengers: Infinity War ";
        carouselTmp.releaseDate = "上映时间：2018-05-11(中国大陆) ";
        carouselTmp.totalTime = "影片时长：150分钟";
        carouselTmp.plotDesc =
                "最先与灭霸军团遭遇的雷神索尔一行遭遇惨烈打击，洛基遇害，空间宝石落入灭霸之手。未几，灭霸的先锋部队杀至地球，一番缠斗后掳走奇异博士。为阻止时间宝石落入敌手，斯塔克和蜘蛛侠闯入了敌人的飞船。与此同时，拥有心灵宝石的幻视也遭到外星侵略者的袭击，为此美国队长、黑寡妇等人将其带到瓦坎达王国，向黑豹求助。幸免于难的索尔与星爵一行相逢，随后他们兵分两路。索尔与火箭、格鲁特踏上再铸雷神之锤的旅程，星爵则与卡魔拉等人试图阻止灭霸的恶行。而知晓灵魂宝石下落的卡魔拉，同样是其义父灭霸追踪的对象。 ";
        carouselTmp.directors = "";
        carouselTmp.actors.add("");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/MARVEL/Avengers3/photos/1.png");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/MARVEL/Avengers3/photos/2.png");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/MARVEL/Avengers3/photos/3.png");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/MARVEL/Avengers3/photos/4.png");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/MARVEL/Avengers3/photos/5.png");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/MARVEL/Avengers3/photos/6.png");
        carouselTmp.createTime = "2018-05-11T07:40:37.000+0000";
        carouselList.add(carouselTmp);

        carouselTmp = new Carousel();
        carouselTmp.id = "marvel-1016";
        carouselTmp.name = "银河护卫队2";
        carouselTmp.poster = "http://122.152.205.72:88/superhero/MARVEL/GuardiansOfTheGalaxy2/poster.png";
        carouselTmp.cover = "http://122.152.205.72:88/superhero/MARVEL/GuardiansOfTheGalaxy2/cover.png";
        carouselTmp.trailer = "http://122.152.205.72:88/superhero/MARVEL/GuardiansOfTheGalaxy2/trailer.mp4";
        carouselTmp.score = 8.7;
        carouselTmp.prisedCounts = 8632;
        carouselTmp.basicInfo = "2018 / 美国 / 科幻 / 超级英雄";
        carouselTmp.originalName = "原名：Guardians of the Galaxy Vol. 2";
        carouselTmp.releaseDate = "上映时间：2017-05-05(中国大陆/美国) ";
        carouselTmp.totalTime = "影片时长：136分钟";
        carouselTmp.plotDesc =
                "火箭浣熊（布莱德利·库珀 Bradley Cooper 饰）偷走了大祭司阿耶莎（伊丽莎白·德比齐 Elizabeth Debicki 饰）的能量电池，包括星爵（克里斯·帕拉特 Chris Pratt 饰）、卡魔拉（佐伊·索尔达娜 Zoe Saldana 饰）、德拉克斯（戴夫·巴蒂斯塔 Dave Bautista 饰）在内的一行人遭到了后者派出的舰队的袭击。一个神秘人物乘坐着飞船救下了银河护卫队的众人，而驾驶着飞船的不是别人，竟然正是星爵的亲生父亲伊戈（库尔特·拉塞尔 Kurt Russell 饰）";
        carouselTmp.directors = "";
        carouselTmp.actors = new ArrayList();
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/MARVEL/GuardiansOfTheGalaxy2/photos/1.png");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/MARVEL/GuardiansOfTheGalaxy2/photos/2.png");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/MARVEL/GuardiansOfTheGalaxy2/photos/3.png");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/MARVEL/GuardiansOfTheGalaxy2/photos/4.png");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/MARVEL/GuardiansOfTheGalaxy2/photos/5.png");
        carouselTmp.createTime = "2017-05-05T07:40:37.000+0000";
        carouselList.add(carouselTmp);

        carouselTmp = new Carousel();
        carouselTmp.id = "marvel-1018";
        carouselTmp.name = "钢铁侠3";
        carouselTmp.poster = "http://122.152.205.72:88/superhero/MARVEL/IronMan3/poster.png";
        carouselTmp.cover = "http://122.152.205.72:88/superhero/MARVEL/IronMan3/cover.png";
        carouselTmp.trailer = "http://122.152.205.72:88/superhero/MARVEL/IronMan3/trailer.mp4";
        carouselTmp.score = 8.7;
        carouselTmp.prisedCounts = 7854;
        carouselTmp.basicInfo = "2018 / 美国 / 科幻 / 超级英雄";
        carouselTmp.originalName = "原名： Iron Man 3";
        carouselTmp.releaseDate = "上映时间：2013-05-01(中国大陆)";
        carouselTmp.totalTime = "影片时长：134分钟";
        carouselTmp.plotDesc =
                "自纽约事件以来，托尼·斯塔克（小罗伯特·唐尼 Robert Downey Jr. 饰）为前所未有的焦虑症所困扰。他疯狂投入钢铁侠升级版的研发，为此废寝忘食，甚至忽略了女友佩珀·波茨（格温妮斯·帕特洛 Gwyneth Paltrow 饰）的感受。与此同时，臭名昭著的恐怖头目曼达林（本·金斯利 Ben Kingsley 饰）制造了一连串的爆炸袭击事件，托尼当年最忠诚的保镖即在最近的一次袭击中身负重伤。未过多久，托尼、佩珀以及曾与他有过一面之缘的女植物学家玛雅（丽贝卡·豪尔 Rebecca Hall 饰）在家中遭到猛烈的炮火袭击，几乎丧命，而这一切似乎都与22年前那名偶然邂逅的科学家阿尔德里奇·基连（盖·皮尔斯 Guy Pearce 饰）及其终极生物的研究有关";
        carouselTmp.directors = "";
        carouselTmp.actors = new ArrayList();
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/MARVEL/IronMan3/photos/1.png");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/MARVEL/IronMan3/photos/2.png");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/MARVEL/IronMan3/photos/3.png");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/MARVEL/IronMan3/photos/4.png");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/MARVEL/IronMan3/photos/5.png");
        carouselTmp.createTime = "2013-05-01T07:40:37.000+0000";
        carouselList.add(carouselTmp);

        carouselTmp = new Carousel();
        carouselTmp.id = "xman-1002";
        carouselTmp.name = "X战警：逆转未来";
        carouselTmp.poster = "http://122.152.205.72:88/superhero/xman/DaysOfFuturePast/poster.png";
        carouselTmp.cover = "http://122.152.205.72:88/superhero/xman/DaysOfFuturePast/cover.png";
        carouselTmp.trailer = "http://122.152.205.72:88/superhero/xman/DaysOfFuturePast/trailer.mp4";
        carouselTmp.score = 8.5;
        carouselTmp.prisedCounts = 7965;
        carouselTmp.basicInfo = "2018 / 美国 / 科幻 / 超级英雄";
        carouselTmp.originalName = "原名：xman: Days of Future Past";
        carouselTmp.releaseDate = "上映时间：2014-05-23(美国/中国大陆)";
        carouselTmp.totalTime = "影片时长：131分钟(美国) ";
        carouselTmp.plotDesc =
                "故事的设定发生在当下，变种人族群遭到了前所未有的毁灭性打击，而这一切的根源是“魔形女”瑞文（詹妮弗·劳伦斯 Jennifer Lawrence 饰）在1973年刺杀了玻利瓦尔·特拉斯克（彼特·丁拉基 Peter Dinklage 饰）。在得知“幻影猫”（艾伦·佩吉 E llen Page 饰）利用穿越时空的能力帮助Blink（范冰冰 饰）等战友逃脱巨型机器人“哨兵”的追杀后，X教授（帕特里克·斯图尔特 Patrick Stewart 饰）和万磁王（伊恩·麦克莱恩 Ian McKellen 饰）达成认同，决定让金刚狼（休·杰克曼 Hugh Jackman 饰）穿越回1973年，找到年轻的X教授（詹姆斯·麦卡沃伊 James McAvoy 饰）和年轻的万磁王（迈克尔·法斯宾德 Michael Fassbender 饰）并说服他们一起阻止魔形女的行动。于是，金刚狼踏上了回到过去的旅程，但是命运会不会发生逆转，任何人都无从知晓";
        carouselTmp.directors = "s-1011";
        carouselTmp.actors.add("s-1017");
        carouselTmp.actors.add("s-1012");
        carouselTmp.actors.add("s-1013");
        carouselTmp.actors.add("s-1014");
        carouselTmp.actors.add("s-1015");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/xman/DaysOfFuturePast/photos/1.png");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/xman/DaysOfFuturePast/photos/2.png");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/xman/DaysOfFuturePast/photos/3.png");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/xman/DaysOfFuturePast/photos/4.png");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/xman/DaysOfFuturePast/photos/5.png");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/xman/DaysOfFuturePast/photos/6.png");
        carouselTmp.createTime = "2014-05-23T07:40:37.000+0000";
        carouselList.add(carouselTmp);

        carouselTmp = new Carousel();
        carouselTmp.id = "xman-1003";
        carouselTmp.name = "X战警：第一战";
        carouselTmp.poster = "http://122.152.205.72:88/superhero/xman/FirstClass/poster.png";
        carouselTmp.cover = "http://122.152.205.72:88/superhero/xman/FirstClass/cover.png";
        carouselTmp.trailer = "http://122.152.205.72:88/superhero/xman/FirstClass/trailer.mp4";
        carouselTmp.score = 8.5;
        carouselTmp.prisedCounts = 7965;
        carouselTmp.basicInfo = "2018 / 美国 / 科幻 / 超级英雄";
        carouselTmp.originalName = "原名：xman: First Class";
        carouselTmp.releaseDate = "上映时间：2011-05-25(纽约首映)";
        carouselTmp.totalTime = "影片时长：132分钟(美国) ";
        carouselTmp.plotDesc =
                "年轻的X教授查尔斯（詹姆斯·麦卡沃伊 James McAvoy 饰）和万磁王埃里克（迈克尔·法斯宾德 Michael Fassbender 饰）是一对志向相投的好朋友。他们最早发现了自己的超能力，并与其他几个变种人一起在CIA工作。引发埃里克超能力的纳粹战争贩子肖（凯文·贝肯 Kevin Bacon 饰）一直试图挑起核战争，而想方设法挑起美苏两国的矛盾。埃里克和查尔斯一直与肖手下的变种人战斗，努力阻止肖的阴谋。肖怂恿苏联引发古巴导弹危机，查尔斯和埃里克获知消息后，在海湾与肖手下的变种人拉开了对决的一战。最终，肖被查尔斯和埃里克合力消灭。可是，在这个过程中，埃里克逐渐被肖的政治观点影响，与查尔斯产生裂痕。通过海湾的这一战，埃里克和查尔斯最终决裂，一方变成支持人类与变种人和平共存的X教授；另一方坚持通过消灭人类换来变种人兴起的观点，自称万磁王..";
        carouselTmp.directors = "s-1018";
        carouselTmp.actors.add("s-1017");
        carouselTmp.actors.add("s-1012");
        carouselTmp.actors.add("s-1013");
        carouselTmp.actors.add("s-1014");
        carouselTmp.actors.add("s-1015");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/xman/FirstClass/photos/1.png");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/xman/FirstClass/photos/2.png");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/xman/FirstClass/photos/3.png");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/xman/FirstClass/photos/4.png");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/xman/FirstClass/photos/5.png");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/xman/FirstClass/photos/6.png");
        carouselTmp.createTime = "2011-05-25T07:40:37.000+0000";
        carouselList.add(carouselTmp);

        carouselTmp = new Carousel();
        carouselTmp.id = "xman-1007";
        carouselTmp.name = "金刚狼：殊死一战";
        carouselTmp.poster = "http://122.152.205.72:88/superhero/xman/Logan/poster.png";
        carouselTmp.cover = "http://122.152.205.72:88/superhero/xman/Logan/cover.png";
        carouselTmp.trailer = "http://122.152.205.72:88/superhero/xman/Logan/trailer.mp4";
        carouselTmp.score = 8.5;
        carouselTmp.prisedCounts = 9631;
        carouselTmp.basicInfo = "2018 / 美国 / 科幻 / 超级英雄";
        carouselTmp.originalName = "原名：xman: Logan";
        carouselTmp.releaseDate = "上映时间：2017-03-03(中国大陆/美国)";
        carouselTmp.totalTime = "影片时长：123分钟(中国大陆)";
        carouselTmp.plotDesc =
                "故事发生在2029年，彼时，X战警早已经解散，作为为数不多的仅存的变种人，金刚狼罗根（休·杰克曼 Hugh Jackman 饰）和卡利班（斯戴芬·莫昌特 Stephen Merchant 饰）照顾着年迈的X教授（帕特里克·斯图尔特 Patrick Stewart 饰），由于衰老，X教授已经丧失了对于自己超能力的控制，如果不依赖药物，他的超能力就会失控，在全球范围内制造无法挽回的灾难。不仅如此，金刚狼的自愈能力亦随着时间的流逝逐渐减弱，体能和力量都早已经大不如从前。 ";
        carouselTmp.directors = "";
        carouselTmp.actors.add("");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/xman/Logan/photos/1.png");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/xman/Logan/photos/2.png");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/xman/Logan/photos/3.png");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/xman/Logan/photos/4.png");
        carouselTmp.plotPics.add("http://122.152.205.72:88/superhero/xman/Logan/photos/5.png");
        carouselTmp.createTime = "2017-03-03T07:40:37.000+0000";
        carouselList.add(carouselTmp);

        return carouselList;
    }
}
