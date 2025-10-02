package com.example.exercice.controller;

import com.example.exercice.model.Exercise;
import com.example.exercice.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Contrôleur pour gérer les opérations liées aux exercices.
 */
@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    @Autowired
    private ExerciseRepository exerciseRepository;

    /**
     * Récupère la liste de tous les exercices.
     *
     * @return Une liste d'exercices.
     */
    @GetMapping("")
    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }

    /**
     * Récupère un exercice par son identifiant.
     *
     * @param id L'identifiant de l'exercice à récupérer.
     * @return Une réponse contenant l'exercice trouvé ou un statut 404 si non trouvé.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Exercise> getExerciseById(@PathVariable Long id) {
        Optional<Exercise> exercise = exerciseRepository.findById(id);
        return exercise.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Crée un nouvel exercice.
     *
     * @param exercise L'objet exercice à créer.
     * @return Une réponse contenant l'exercice créé et un statut 201.
     */
    @PostMapping("")
    public ResponseEntity<Exercise> createExercise(@RequestBody Exercise exercise) {
        Exercise savedExercise = exerciseRepository.save(exercise);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedExercise);
    }

    /**
     * Met à jour un exercice existant.
     *
     * @param id              L'identifiant de l'exercice à mettre à jour.
     * @param exerciseDetails Les détails de l'exercice à mettre à jour.
     * @return Une réponse contenant l'exercice mis à jour ou un statut 404 si non trouvé.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Exercise> updateExercise(@PathVariable Long id, @RequestBody Exercise exerciseDetails) {
        Optional<Exercise> optionalExercise = exerciseRepository.findById(id);

        if (optionalExercise.isPresent()) {
            Exercise existingExercise = optionalExercise.get();
            existingExercise.setName(exerciseDetails.getName());
            existingExercise.setDescription(exerciseDetails.getDescription());
            Exercise updatedExercise = exerciseRepository.save(existingExercise);
            return ResponseEntity.ok(updatedExercise);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Supprime un exercice par son identifiant.
     *
     * @param id L'identifiant de l'exercice à supprimer.
     * @return Une réponse avec un statut 204 si supprimé ou un statut 404 si non trouvé.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExercise(@PathVariable Long id) {
        Optional<Exercise> optionalExercise = exerciseRepository.findById(id);

        if (optionalExercise.isPresent()) {
            exerciseRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
