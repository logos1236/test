package logos.main.logos.WorldObjects;

import java.util.ArrayList;

/**
 * Created by Logos on 22.05.2017.
 */
public class WorldObjects {
    /*=== About ===*/
    private String name;
    private int id;

    /*=== Physical ===*/
    private int weight;
    private ArrayList<Material> material;

    public WorldObjects(String name, int weight, ArrayList<Material> material) {
        this.id = 1;

        this.name = name;
        this.weight = weight;
        this.material = material;
    }

    public String GetName() {
        return this.name;
    }

    public int GetWeight() {
        return this.weight;
    }

    /*=== Сжигаем объект ===*/
    public ArrayList<WorldObjects> BurnObject() {
        ArrayList<WorldObjects> result_list = new ArrayList<WorldObjects>();
        ArrayList<Material> material_list = new ArrayList<Material>();

        material_list = this.GetObjectMaterial();

        for(Material material_list_obj: material_list) {
            /*=== Сжигаем материалы, из которых состоит объект ===*/
            ArrayList<Material> material_list_obj_burn = new ArrayList<Material>();
            material_list_obj_burn = material_list_obj.BurnMaterial();

            for (Material material_list_obj_burn_obj: material_list_obj_burn) {
                /*=== Создаем новый объект и отправляем его в список результатов ===*/
                if (material_list_obj_burn_obj.isSolid()) {
                    ArrayList<Material> result_material_l = new ArrayList<Material>();
                    result_material_l.add(material_list_obj_burn_obj);
                    WorldObjects result_elem = new WorldObjects(material_list_obj_burn_obj.getName(), this.GetWeight(), result_material_l);

                    result_list.add(result_elem);
                }
            }
        }

        return result_list;
    }

    /*=== Получаем список материалов, из которых состоит объект ===*/
    public ArrayList<Material> GetObjectMaterial() {
        ArrayList<Material> result_list = new ArrayList<Material>();
        result_list = this.material;

        return result_list;
    }
}
