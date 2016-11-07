package wrap;

import shop.CharacteristicsEntity;
/**
 * Created by Роман on 05.11.2016.
 */
public interface CharacteristicsInt {
    public void save(CharacteristicsEntity characteristicsEntity);
    public void delete(long id);
    public void update(CharacteristicsEntity characteristicsEntity);
    public CharacteristicsEntity getEntityById(long id);
}
