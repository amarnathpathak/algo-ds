package com.snap;

public class RobotMovement {
    public enum MOVE {
        G, L, R;
    }

    public boolean isCircle(int startX, int startY, String... moves) {
        int iStartX = startX;
        int iStartY = startY;
        int movesCount = moves.length;
        int count = 0;
        String direction = "e";
        while (count < movesCount) {
            MOVE m = MOVE.valueOf(moves[count++]);
            direction = getDirection(direction, m);
            if (direction.equals("n")) {
                startY = startY + 1;
            }
            if (direction.equals("s")) {
                startY = startY - 1;
            }
            if (direction.equals("e")) {
                startX = startX + 1;
            }
            if (direction.equals("w")) {
                startX = startX - 1;
            }
        }
        return iStartX == startX && iStartY == startY;
    }

    private String getDirection(String intialDirection, MOVE move) {
        if(MOVE.G.equals(move)){
            return intialDirection.toLowerCase();
        }
        intialDirection = intialDirection.toLowerCase();
        String direction = intialDirection;
        switch (intialDirection) {
        case "e":
            direction = move.equals(MOVE.L) ? "n" : "s";
            break;
        case "s":
            direction = move.equals(MOVE.L) ? "e" : "w";
            break;
        case "w":
            direction = move.equals(MOVE.L) ? "s" : "n";
            break;
        case "n":
            direction = move.equals(MOVE.L) ? "w" : "e";
            break;
        default:
            direction = intialDirection;
        }
        return direction;
    }

}
