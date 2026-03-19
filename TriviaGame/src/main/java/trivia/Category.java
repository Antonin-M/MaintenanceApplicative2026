package trivia;

public enum Category {
    POP, SCIENCE, SPORTS, ROCK;

    public static Category categoryFromPlace(int place) {
        int cat = (place - 1) % 4;
        return switch (cat) {
            case 0 -> POP;
            case 1 -> SCIENCE;
            case 2 -> SPORTS;
            default -> ROCK;
        };
    }

    @Override
    public String toString() {
        return switch (this) {
            case POP -> "Pop";
            case SCIENCE -> "Science";
            case SPORTS -> "Sports";
            case ROCK -> "Rock";
        };
    }
}
