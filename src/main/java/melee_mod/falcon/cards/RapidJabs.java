package melee_mod.falcon.cards;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import melee_mod.FalconCharacterMod;
import melee_mod.actions.RapidJabsAction;
import melee_mod.falcon.patches.AbstractCardEnum;
import globals.Constants;

public class RapidJabs extends CustomCard {
    private static final String ID = Constants.CardNames.RAPID_JABS;
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    private static final String NAME = cardStrings.NAME;
    private static final String DESCRIPTION = cardStrings.DESCRIPTION;
    private static final int COST = -1;
    private static final int BASE_DAMAGE = 2;
    private static final int BASE_MULTIPLIER = 2;
    private static final int UPGRADE_MULTIPLIER = 1;

    public RapidJabs() {
        super(ID, NAME, FalconCharacterMod.makeCardImagePath(ID), COST, DESCRIPTION,
                CardType.ATTACK, AbstractCardEnum.FALCON_BLUE,
                AbstractCard.CardRarity.UNCOMMON, AbstractCard.CardTarget.ENEMY);
        this.damage = this.baseDamage = BASE_DAMAGE;
        this.magicNumber = this.baseMagicNumber = BASE_MULTIPLIER;
    }

    @Override
    public AbstractCard makeCopy() {
        return new RapidJabs();
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(UPGRADE_MULTIPLIER);
        }
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster) {
        this.addToBot(new RapidJabsAction(player, monster, this.damage, this.damageTypeForTurn, this.freeToPlayOnce, this.energyOnUse, this.magicNumber));
    }
}
