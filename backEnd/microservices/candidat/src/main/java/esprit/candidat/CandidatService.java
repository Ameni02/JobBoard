package esprit.candidat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatService {
    @Autowired
    private CandidatRepository candidatRepository;
    public List<Candidat> findAll() {
        return candidatRepository.findAll();
    }

    public Candidat addCandidat(Candidat candidate)
    { return candidatRepository.save(candidate);
    }
    public Candidat updateCandidat(int id, Candidat newCandidat) {
        if (candidatRepository.findById(id).isPresent()) {

            Candidat existingCandidat = candidatRepository.findById(id).get();
            existingCandidat.setFirstName(newCandidat.getFirstName());
            existingCandidat.setLastName(newCandidat.getLastName());
            existingCandidat.setEmail(newCandidat.getEmail());

            return candidatRepository.save(existingCandidat);
        } else
            return null;
    }

    public String deleteCandidat(int id) {
        if (candidatRepository.findById(id).isPresent()) { candidatRepository.deleteById(id);
            return "candidat supprimé";
        } else
            return "candidat non supprimé";
    }

}
