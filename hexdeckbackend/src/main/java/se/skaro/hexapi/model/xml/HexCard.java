package se.skaro.hexapi.model.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class HexCard {

	@XmlElement(name = "Card")
	private String name;

	@XmlElement(name = "Set")
	private String set;

	@XmlElement(name = "Shard")
	private String shard;

	@XmlElement(name = "Rarity")
	private String rarity;

	@XmlElement(name = "Type")
	private String type;

	@XmlElement(name = "Traits")
	private String traits;

	@XmlElement(name = "Unique")
	private String unique;

	@XmlElement(name = "Cost")
	private String cost;

	@XmlElement(name = "Blood")
	private Integer blood;

	@XmlElement(name = "Diamond")
	private Integer diamond;

	@XmlElement(name = "Ruby")
	private Integer ruby;

	@XmlElement(name = "Sapphire")
	private Integer sapphire;

	@XmlElement(name = "Wild")
	private Integer wild;

	@XmlElement(name = "Attack")
	private String attack;

	@XmlElement(name = "Defense")
	private String defence;

	@XmlElement(name = "Card_x0020_Text")
	private String text;

	@XmlElement(name = "GUID")
	private String guid;

	@XmlElement(name = "Flavor_x0020_Text")
	private String flavorText;
	
	@XmlElement(name = "Quick")
	private String quick;

	public String getName() {
		return name;
	}

	public void setName(String card) {
		this.name = card;
	}

	public String getSet() {
		return set;
	}

	public void setSet(String set) {
		this.set = set;
	}

	public String getShard() {
		return shard;
	}

	public void setShard(String shard) {
		this.shard = shard;
	}

	public String getRarity() {
		return rarity;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTraits() {
		return traits;
	}

	public void setTraits(String traits) {
		this.traits = traits;
	}

	public String getUnique() {
		if (unique == null) {
			return "";
		}
		return unique;
	}

	public void setUnique(String unique) {
		this.unique = unique;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public Integer getBlood() {
		return blood;
	}

	public void setBlood(Integer blood) {
		this.blood = blood;
	}

	public Integer getDiamond() {
		return diamond;
	}

	public void setDiamond(Integer diamond) {
		this.diamond = diamond;
	}

	public Integer getRuby() {
		return ruby;
	}

	public void setRuby(Integer ruby) {
		this.ruby = ruby;
	}

	public Integer getSapphire() {
		return sapphire;
	}

	public void setSapphire(Integer sapphire) {
		this.sapphire = sapphire;
	}

	public Integer getWild() {
		return wild;
	}

	public void setWild(Integer wild) {
		this.wild = wild;
	}

	public String getAttack() {
		return attack;
	}

	public void setAttack(String attack) {
		this.attack = attack;
	}

	public String getDefence() {
		return defence;
	}

	public void setDefence(String defence) {
		this.defence = defence;
	}

	public String getText() {
		return text.replaceAll("\n", " ");
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getFlavorText() {
		return flavorText;
	}

	public void setFlavorText(String flavorText) {
		this.flavorText = flavorText;
	}

	public String getQuick() {
		return quick;
	}

	public void setQuick(String quick) {
		this.quick = quick;
	}

	
}
