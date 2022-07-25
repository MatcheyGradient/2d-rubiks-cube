import java.awt.*;

public class MainCube {

    // man wtf is this. this defines the solved/startup state
    public static StickerColor[][] topFace = {{StickerColor.WHITE, StickerColor.WHITE, StickerColor.WHITE}, {StickerColor.WHITE, StickerColor.WHITE, StickerColor.WHITE}, {StickerColor.WHITE, StickerColor.WHITE, StickerColor.WHITE}};
    static StickerColor[][] frontFace = {{StickerColor.GREEN, StickerColor.GREEN, StickerColor.GREEN}, {StickerColor.GREEN, StickerColor.GREEN, StickerColor.GREEN}, {StickerColor.GREEN, StickerColor.GREEN, StickerColor.GREEN}};
    static StickerColor[][] rightFace = {{StickerColor.RED, StickerColor.RED, StickerColor.RED}, {StickerColor.RED, StickerColor.RED, StickerColor.RED}, {StickerColor.RED, StickerColor.RED, StickerColor.RED}}; // to the people who don't give a shit, an old friend of mine made my pfp (quackk)
    static StickerColor[][] backFace = {{StickerColor.BLUE, StickerColor.BLUE, StickerColor.BLUE}, {StickerColor.BLUE, StickerColor.BLUE, StickerColor.BLUE}, {StickerColor.BLUE, StickerColor.BLUE, StickerColor.BLUE}};
    static StickerColor[][] leftFace = {{StickerColor.ORANGE, StickerColor.ORANGE, StickerColor.ORANGE}, {StickerColor.ORANGE, StickerColor.ORANGE, StickerColor.ORANGE}, {StickerColor.ORANGE, StickerColor.ORANGE, StickerColor.ORANGE}};
    static StickerColor[][] bottomFace = {{StickerColor.YELLOW, StickerColor.YELLOW, StickerColor.YELLOW}, {StickerColor.YELLOW, StickerColor.YELLOW, StickerColor.YELLOW}, {StickerColor.YELLOW, StickerColor.YELLOW, StickerColor.YELLOW}};



    public void render(Graphics g){
        for(int i = 0; i < 3; i++){ // draws left side
            for(int j = 0; j < 3; j++){
                g.setColor(getColor(leftFace[i][j]));
                g.fillRect(20 + 30 * j, 130 + 30 * i, 27, 27);
            }
        }
        for(int i = 0; i < 3; i++){ // draws front side
            for(int j = 0; j < 3; j++){
                g.setColor(getColor(frontFace[i][j]));
                g.fillRect(130 + 30 * j, 130 + 30 * i, 27, 27);
            }
        }
        for(int i = 0; i < 3; i++){ // draws right side
            for(int j = 0; j < 3; j++){
                g.setColor(getColor(rightFace[i][j]));
                g.fillRect(240 + 30 * j, 130 + 30 * i, 27, 27);
            }
        }
        for(int i = 0; i < 3; i++){ // draws back side
            for(int j = 0; j < 3; j++){
                g.setColor(getColor(backFace[i][j]));
                g.fillRect(350 + 30 * j, 130 + 30 * i, 27, 27);
            }
        }
        for(int i = 0; i < 3; i++){ // draws top side
            for(int j = 0; j < 3; j++){
                g.setColor(getColor(topFace[i][j]));
                g.fillRect(130 + 30 * j, 20 + 30 * i, 27, 27);
            }
        }
        for(int i = 0; i < 3; i++){ // draws bottom side
            for(int j = 0; j < 3; j++){
                g.setColor(getColor(bottomFace[i][j]));
                g.fillRect(130 + 30 * j, 240 + 30 * i, 27, 27);
            }
        }
    }

    public static Color getColor (StickerColor piece){
        if (piece == StickerColor.WHITE){
            return Color.WHITE;
        } else if (piece == StickerColor.RED){
            return new Color(204, 0, 0);
        } else if (piece == StickerColor.BLUE){
            return Color.BLUE;
        } else if (piece == StickerColor.ORANGE){
            return new Color(244, 110, 57);
        } else if (piece == StickerColor.GREEN){
            return Color.GREEN;
        } else if (piece == StickerColor.YELLOW){
            return Color.YELLOW;
        }

        return Color.gray;
    }

    public static void rotateFaceCW(StickerColor[][] sticker) {
        for (int i = 0; i < 3; i++){
            for (int j = i; j < 3; j++){ // this step will always swap a sticker to a location below it. this is why we set j to i, because if not, the sticker will switch back to its original position when the for loops loop over the 2nd position. if j = i, it won't be able to loop over a position above it
                StickerColor storeSticker = sticker[i][j]; // holds the sticker color at [i][j] because the next few steps will interfere with it
                sticker[i][j] = sticker[j][i];
                sticker[j][i] = storeSticker;
            }
        }

        for (int i = 0; i < 3; i++){ // since im only dealing with a row length of 3, I can just swap the 2 ends
            StickerColor temp = sticker[i][0];
            sticker[i][0] = sticker[i][2];
            sticker[i][2] = temp;
        }
    }

    public static void topCW(){
        rotateFaceCW(topFace);
        for(int i = 0; i < 3; i++){
            StickerColor temp = frontFace[0][i];
            frontFace[0][i] = rightFace[0][i];
            rightFace[0][i] = backFace[0][i];
            backFace[0][i] = leftFace[0][i];
            leftFace[0][i] = temp;
        }
    }

    public static void frontCW(){
        rotateFaceCW(frontFace);
        for(int i = 0; i < 3; i++){
            StickerColor temp = topFace[2][i];
            topFace[2][i] = leftFace[2 - i][2];
            leftFace[2 - i][2] = bottomFace[0][2 - i];
            bottomFace[0][2-i] = rightFace[i][0];
            rightFace[i][0] = temp;
        }
    }

    public static void bottomCW(){
        rotateFaceCW(bottomFace);
        for(int i = 0; i < 3; i++){
            StickerColor temp = frontFace[2][i];
            frontFace[2][i] = leftFace[2][i];
            leftFace[2][i] = backFace[2][i];
            backFace[2][i] = rightFace[2][i];
            rightFace[2][i] = temp;
        }
    }

    public static void leftCW(){
        rotateFaceCW(leftFace);
        for(int i = 0; i < 3; i++){
            StickerColor temp = frontFace[2 - i][0];
            frontFace[2 - i][0] = topFace[2 - i][0];
            topFace[2 - i][0] = backFace[i][2];
            backFace[i][2] = bottomFace[2 - i][0];
            bottomFace[2 - i][0] = temp;
        }
    }

    public static void rightCW(){
        rotateFaceCW(rightFace);
        for(int i = 0; i < 3; i++){
            StickerColor temp = frontFace[i][2];
            frontFace[i][2] = bottomFace[i][2];
            bottomFace[i][2] = backFace[2 - i][0];
            backFace[2 - i][0] = topFace[i][2];
            topFace[i][2] = temp;
        }
    }

    public static void backCW(){
        rotateFaceCW(backFace);
        for(int i = 0; i < 3; i++){
            StickerColor temp = topFace[0][i];
            topFace[0][i] = rightFace[i][2];
            rightFace[i][2] = bottomFace[2][2 - i];
            bottomFace[2][2 - i] = leftFace[2 - i][0];
            leftFace[2 - i][0] = temp;
        }
    }

    public static void rotateCubeRight(){
        rotateFaceCW(topFace);
        rotateFaceCW(bottomFace); // aww hell naw
        rotateFaceCW(bottomFace);
        rotateFaceCW(bottomFace);
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                StickerColor temp = frontFace[i][j];
                frontFace[i][j] = rightFace[i][j];
                rightFace[i][j] = backFace[i][j];
                backFace[i][j] = leftFace[i][j];
                leftFace[i][j] = temp;
            }
        }
    }

    public static void resetCube(){
        topFace = new StickerColor[][]{{StickerColor.WHITE, StickerColor.WHITE, StickerColor.WHITE}, {StickerColor.WHITE, StickerColor.WHITE, StickerColor.WHITE}, {StickerColor.WHITE, StickerColor.WHITE, StickerColor.WHITE}};
        frontFace = new StickerColor[][]{{StickerColor.GREEN, StickerColor.GREEN, StickerColor.GREEN}, {StickerColor.GREEN, StickerColor.GREEN, StickerColor.GREEN}, {StickerColor.GREEN, StickerColor.GREEN, StickerColor.GREEN}};
        rightFace = new StickerColor[][]{{StickerColor.RED, StickerColor.RED, StickerColor.RED}, {StickerColor.RED, StickerColor.RED, StickerColor.RED}, {StickerColor.RED, StickerColor.RED, StickerColor.RED}};
        backFace = new StickerColor[][]{{StickerColor.BLUE, StickerColor.BLUE, StickerColor.BLUE}, {StickerColor.BLUE, StickerColor.BLUE, StickerColor.BLUE}, {StickerColor.BLUE, StickerColor.BLUE, StickerColor.BLUE}};
        leftFace = new StickerColor[][]{{StickerColor.ORANGE, StickerColor.ORANGE, StickerColor.ORANGE}, {StickerColor.ORANGE, StickerColor.ORANGE, StickerColor.ORANGE}, {StickerColor.ORANGE, StickerColor.ORANGE, StickerColor.ORANGE}};
        bottomFace = new StickerColor[][]{{StickerColor.YELLOW, StickerColor.YELLOW, StickerColor.YELLOW}, {StickerColor.YELLOW, StickerColor.YELLOW, StickerColor.YELLOW}, {StickerColor.YELLOW, StickerColor.YELLOW, StickerColor.YELLOW}};
    }

    public enum StickerColor { // to make the code make more sense and readable (never was 😈)
        WHITE,
        RED,
        BLUE,
        ORANGE,
        GREEN,
        YELLOW
    }
}
