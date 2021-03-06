package melee_mod.falcon.powers;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.ArtifactPower;
import melee_mod.FalconCharacterMod;

import static globals.Constants.Powers.REMOVE_ARTIFACTS;

public class RemoveArtifactsPower extends AbstractPower {
    private static final String POWER_ID = REMOVE_ARTIFACTS;
    private static final String NAME = "Remove Artifacts";

    public RemoveArtifactsPower(AbstractCreature owner, int amount) {
        this.name = NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = amount;
        this.updateDescription();
        this.img = new Texture(FalconCharacterMod.makePowerImagePath(POWER_ID));
    }

    @Override
    public void updateDescription() {
        this.description = "Lose " + this.amount + " Artifact(s) at the end of the turn. Cannot be negated by Artifact.";
    }

    public void atEndOfRound() {
        AbstractDungeon.actionManager.addToBottom(new ReducePowerAction(this.owner, this.owner, ArtifactPower.POWER_ID, this.amount));
        AbstractDungeon.actionManager
                .addToBottom(new com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction(this.owner,
                        this.owner, this));
    }
}
