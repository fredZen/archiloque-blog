boolean tryToGo(int currentPosition, byte direction) {
  int targetPosition = calculatePosition(currentPosition, direction);
  int targetPositionContent = content[targetPosition];

  int[] newContent;
  switch (targetPositionContent) {
    case Tiles.WALL:
      return false;
    case Tiles.EMPTY:
      newContent = content.clone();
      newContent[targetPosition] = Tiles.BABA;
      newContent[currentPosition] = Tiles.EMPTY;
      level.addState(newContent);
      return false;
    case Tiles.ROCK:
      // @TODO implements this
      return false;
    case Tiles.FLAG:
      return true;
    default:
      throw new IllegalArgumentException("" + targetPositionContent);
  }
}

private int calculatePosition(int position, byte direction) {
  switch (direction) {
    case Direction.UP:
      return position - level.width;
    case Direction.DOWN:
      return position + level.width;
    case Direction.LEFT:
      return position - 1;
    case Direction.RIGHT:
      return position + 1;
    default:
      throw new IllegalArgumentException("" + direction);
  }
}