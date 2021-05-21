package model;

import java.util.Observable;
import java.io.IOException;

public class BoulderDashModel implements IBoulderDashModel{

    private ISurf   surf;

    private IMobile player;
    
    public BoulderDashModel(final String fileName, final int playerStartX, final int playerStartY)
            throws IOException {
        this.setSurf(new Surf(fileName));
        this.setPlayer(new Player(playerStartX, playerStartY, this.getSurf()));
    }

    public final ISurf getSurf() {
        return this.surf;
    }

    private void setSurf(final ISurf surf) {
        this.surf = surf;
    }

    public final IMobile getPlayer() {
        return this.player;
    }

    private void setPlayer(final IMobile player) {
        this.player = player;
    }

}

	

}
