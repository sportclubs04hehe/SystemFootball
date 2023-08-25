package vietnam.com.football_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vietnam.com.football_system.entity.Team;
import vietnam.com.football_system.entity.User;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    List<Team> findTeamByLeader (User leader);
    List<Team> findTeamByNameContainingIgnoreCase(String teamName);
    @Query("select t from Team t where t.id not in (select m.team1.id from Match m where m.matchDate = :date) and t.id not in (select m.team2.id from Match m where m.matchDate = :date)")
    List<Team> findAvailableTeamsOnDate(LocalDate date);
    List<Team> findTeamByMembersContains(User user);
}

