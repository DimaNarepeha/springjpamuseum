package ua.home.dao.Impl;

import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.home.dao.ExhibitGuideDao;
import ua.home.dao.GuideDAO;
import ua.home.entity.*;

import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
@Transactional
public class ExhibitGuideDaoImpl implements ExhibitGuideDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private GuideDAO guideDAO;

    @Override
    public List<Guide> getGuidesByExhibitId(int id) {
        SessionImpl sessionImpl = (SessionImpl) sessionFactory.getCurrentSession();
        Connection conn = sessionImpl.connection();
        List<Guide> guides = new ArrayList<>();
        try (PreparedStatement getGuides = conn.prepareStatement("SELECT g.id_guide, firstname,lastname  FROM guide g " +
                " INNER JOIN exhibit_guide ON exhibit_guide.id_guide=g.id_guide " +
                "WHERE exhibit_guide.id_exhibit=?")) {
            getGuides.setInt(1, id);
            ResultSet rs = getGuides.executeQuery();
            while (rs.next()) {
                Guide guide = new Guide();
                guide.setId(rs.getInt("id_guide"));
                guide.setFirstName(rs.getString("firstname"));
                guide.setLastName(rs.getString("lastname"));
                guides.add(guide);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Database fail");
            return null;
        }
        return guides;
    }

    @Override
    public List<Exhibit> getExhibitsByGuideId(int id) {
        List<Exhibit> result = new ArrayList<>();
        SessionImpl sessionImpl = (SessionImpl) sessionFactory.getCurrentSession();
        Connection conn = sessionImpl.connection();
        try (PreparedStatement selectFromExhibit = conn
                .prepareStatement("SELECT exhibit.id_exhibit,exhibit_name, hall_name, FIRSTNAME, LASTNAME, material_name, technique_name FROM exhibit\n" +
                        "INNER JOIN hall ON hall.id_hall=exhibit.id_hall\n" +
                        "INNER JOIN material ON material.id_material=exhibit.id_material\n" +
                        "INNER JOIN technique ON technique.id_technique=exhibit.id_technique\n" +
                        "INNER JOIN author_exhibit ON author_exhibit.id_exhibit=exhibit.id_exhibit\n" +
                        "INNER JOIN author ON author.id_author=author_exhibit.id_author\n" +
                        "INNER JOIN exhibit_guide ON exhibit_guide.id_exhibit=exhibit.id_exhibit " +
                        "WHERE exhibit_guide.id_guide = ?;")) {
            selectFromExhibit.setInt(1, id);
            ResultSet resultSet = selectFromExhibit.executeQuery();

            while (resultSet.next()) {
                Hall hall = new Hall();
                hall.setHall_name(resultSet.getString(3));
                Author author = new Author();
                author.setFirstname(resultSet.getString(4));
                author.setLastname(resultSet.getString(5));
                Set<Author> authorSet = new HashSet<>();
                authorSet.add(author);
                Material material = new Material();
                material.setMaterial_name(resultSet.getString(6));
                Technique technique = new Technique();
                technique.setTechnique_name(resultSet.getString(7));
                Exhibit exhibitEntity = new Exhibit();
                exhibitEntity.setId(resultSet.getInt(1));
                exhibitEntity.setExhibit_name(resultSet.getString(2));
                exhibitEntity.setHall(hall);
                exhibitEntity.setAuthors(authorSet);
                exhibitEntity.setMaterial(material);
                exhibitEntity.setTechnique(technique);
                result.add(exhibitEntity);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return result;
        }
        return result;
    }

    @Override
    public List<Guide> getGuidesThatAreNotInThisExhibitById(int id) {
        SessionImpl sessionImpl = (SessionImpl) sessionFactory.getCurrentSession();
        Connection conn = sessionImpl.connection();
        try (PreparedStatement getGuides = conn.prepareStatement("SELECT g.id_guide, firstname,lastname FROM guide g \n" +
                "                INNER JOIN exhibit_guide ON exhibit_guide.id_guide=g.id_guide \n" +
                "                 where exhibit_guide.id_exhibit=?;")) {
            List<Guide> guideEntities = guideDAO.findAll();
            List<Guide> guidesByExhibitId = getGuidesByExhibitId(id);
            Iterator iterator = guidesByExhibitId.iterator();
            while (iterator.hasNext()) {
                Guide g = (Guide) iterator.next();
                Iterator iterator1 = guideEntities.iterator();
                while (iterator1.hasNext()) {
                    Guide g2 = (Guide) iterator1.next();
                    if (g.getId() == g2.getId()) {
                        iterator1.remove();
                    }
                }
            }
            return guideEntities;
        } catch (SQLException e) {
            System.out.println("Database fail");
            return null;
        }
    }

    @Override
    public int reconnectRelations(HashSet<Integer> guidesToExhibit, int exhibitId) {
        int result = 0; //if null then nothing was changed
        HashSet<Integer> guidesThatAlreadyPresent = new HashSet<>();
        SessionImpl sessionImpl = (SessionImpl) sessionFactory.getCurrentSession();
        Connection conn = sessionImpl.connection();
        try (PreparedStatement selectAllConnections = conn
                .prepareStatement("SELECT exhibit_guide.id_guide FROM exhibit\n" +
                        "INNER JOIN exhibit_guide ON exhibit_guide.id_exhibit=exhibit.id_exhibit " +
                        "WHERE exhibit_guide.id_exhibit = ?;");
             PreparedStatement deleteFromGuideExhibit = conn
                     .prepareStatement("DELETE FROM exhibit_guide WHERE id_guide = ? AND id_exhibit=? ;");
             PreparedStatement addGuideExhibit = conn
                     .prepareStatement("INSERT INTO exhibit_guide(id_guide,id_exhibit)" +
                             "VALUES (?,?)")) {
            selectAllConnections.setInt(1, exhibitId);
            ResultSet resultSet = selectAllConnections.executeQuery();
            while (resultSet.next()) {
                guidesThatAlreadyPresent.add(resultSet.getInt(1));
            }

            Iterator iterator = guidesThatAlreadyPresent.iterator();
            while (iterator.hasNext()) {
                deleteFromGuideExhibit.setInt(1, (Integer) iterator.next());
                deleteFromGuideExhibit.setInt(2, exhibitId);
                deleteFromGuideExhibit.execute();
            }
            iterator = guidesToExhibit.iterator();
            while (iterator.hasNext()) {
                addGuideExhibit.setInt(1, (Integer) iterator.next());
                addGuideExhibit.setInt(2, exhibitId);
                addGuideExhibit.execute();
            }
            return 1;
        } catch (SQLException e) {
            System.out.println("Database fail");
            return result;
        }
    }
}
