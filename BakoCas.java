package school.hei.patrimoine.cas.bako;

import school.hei.patrimoine.cas.Cas;
import school.hei.patrimoine.modele.Argent;
import school.hei.patrimoine.modele.Devise;
import school.hei.patrimoine.modele.Personne;
import school.hei.patrimoine.modele.possession.Compte;
import school.hei.patrimoine.modele.possession.FluxArgent;
import school.hei.patrimoine.modele.possession.Materiel;
import school.hei.patrimoine.modele.possession.Possession;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

import static java.time.Month.*;
import static school.hei.patrimoine.modele.Devise.MGA;

public class BakoCas extends Cas {

    public BakoCas(LocalDate ajd, LocalDate finSimulation, Map<Personne, Double> possesseurs) {
        super(ajd, finSimulation, possesseurs);
    }

    @Override
    protected Devise devise() {
        return MGA;
    }

    @Override
    protected String nom() {
        return "";
    }

    @Override
    protected void init() {

    }

    @Override
    protected void suivi() {

    }

    @Override
    public Set<Possession> possessions() {
        var bni = new Compte(
                "bni",
                LocalDate.of(2025, APRIL, 8),
                new Argent(2_000_000, MGA)
        );
        var bmoi = new Compte(
                "bmoi",
                LocalDate.of(2025, APRIL, 8),
                new Argent(625_000, MGA)
        );
        var coffre = new Compte(
                "coffre fort",
                LocalDate.of(2025, APRIL, 8),
                new Argent(1_750_000, MGA)
        );
        new FluxArgent(
                "Travail",
                bni,
                LocalDate.of(2025, APRIL, 8),
                LocalDate.of(2025, DECEMBER, 31),
                2,
                new Argent(2_125_000, MGA)
        );
        new FluxArgent(
                "Epargne",
                bni,
                LocalDate.of(2025, APRIL, 8),
                LocalDate.of(2025, DECEMBER, 31),
                3,
                new Argent(-200_000, MGA)
        );
        new FluxArgent(
                "Epargne",
                bmoi,
                LocalDate.of(2025, APRIL, 8),
                LocalDate.of(2025, DECEMBER, 31),
                3,
                new Argent(200_000, MGA)
        );
        new FluxArgent(
                "Collocation",
                bni,
                LocalDate.of(2025, APRIL, 8),
                LocalDate.of(2025, DECEMBER, 31),
                26,
                new Argent(-600_000, MGA)
        );
        new FluxArgent(
                "Depense",
                bni,
                LocalDate.of(2025, APRIL, 1),
                LocalDate.of(2025, DECEMBER, 31),
                1,
                new Argent(-700_000, MGA)
        );
        var ordi = new Materiel(
                "Ordinateur portable",
                LocalDate.of(2025, APRIL, 8),
                LocalDate.of(2025, APRIL, 8),
                new Argent(3_000_000, MGA),
                -0.12
        );
        return Set.of(bni,bmoi,ordi ,coffre);
    }
}
