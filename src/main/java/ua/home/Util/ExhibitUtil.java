package ua.home.Util;

import ua.home.entity.*;

import java.util.*;

/**
 * this class helps with parsing strings
 * and checking values.
 */
public class ExhibitUtil {
    /**
     * parse json string to exhibit object.
     *
     * @param jsonPairs json string
     * @return exhibit that was parsed
     */
    public static Exhibit getExhibitFromString(String jsonPairs) {
        Exhibit exhibit = new Exhibit();
        Map<String, String> query_pairs = new HashMap<String, String>();
        String[] pairs = jsonPairs.split("&");
        try {
            for (String pair : pairs) {
                int idx = pair.indexOf("=");
                query_pairs.put((pair.substring(0, idx)), pair.substring(idx + 1));
            }
            Hall hall = new Hall();
            hall.setHall_name(query_pairs.get("hall"));
            Author author = new Author();
            author.setFirstname(query_pairs.get("firstname"));
            author.setLastname(query_pairs.get("lastname"));
            Material material = new Material();
            material.setMaterial_name(query_pairs.get("material"));
            Technique technique = new Technique();
            technique.setTechnique_name(query_pairs.get("technique"));
            Set<Author> authors = new HashSet<Author>();
            authors.add(author);
            //add to the exhibit
            exhibit.setExhibit_name(query_pairs.get("exhibit_name"));
            exhibit.setAuthors(authors);
            exhibit.setHall(hall);
            exhibit.setMaterial(material);
            exhibit.setTechnique(technique);
            if (query_pairs.get("id") != null) {
                exhibit.setId(Integer.parseInt(query_pairs.get("id")));
            }
        } catch (NumberFormatException e) {
            return exhibit;
        }
        return exhibit;
    }

    /**
     * check exhibit object on empty fields.
     *
     * @param exhibit exhibit to check
     * @return true if no empty fields or false if there are
     */
    public static boolean checkIfNoEmptyFieldsIn(Exhibit exhibit) {
        try {
            Iterator iterator = exhibit.getAuthors().iterator();
            while (iterator.hasNext()) {
                Author author = (Author) iterator.next();
                if (author == null || author.getLastname().equals("") || author.getFirstname().equals("")) {
                    return false;
                }
            }
            if (exhibit.getHall().getHall_name() == null || exhibit.getHall().getHall_name().equals("")
                    || exhibit.getTechnique().getTechnique_name() == null || exhibit.getTechnique().getTechnique_name().equals("")
                    || exhibit.getMaterial().getMaterial_name() == null || exhibit.getMaterial().getMaterial_name().equals("")
                    || exhibit.getExhibit_name() == null || exhibit.getExhibit_name().equals("")
                    || exhibit.getAuthors() == null || exhibit.getAuthors().size() == 0) {
                return false;
            } else {
                return true;
            }
        } catch (NullPointerException e) {
            return false;
        }
    }
}
