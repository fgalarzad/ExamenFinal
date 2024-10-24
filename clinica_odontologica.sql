create database clinica_odontologica 

use clinica_odontologica 

drop database clinica_odontologica 

create table Medicos
(idMedicos int  AUTO_INCREMENT PRIMARY KEY,
nombre varchar(50),
especialidad varchar(50),
tipo varchar(50)
)

INSERT INTO Medicos VALUES 
(1,'Dr. Juan Pérez', 'Cardiología', 'Titular'),
(2,'Dra. Ana Gómez', 'Pediatría', 'Titular'),
(3,'Dr. Luis Martínez', 'Neurología', 'Residente'),
(4,'Dra. María Sánchez', 'Dermatología', 'Titular'),
(5,'Dr. Carlos López', 'Traumatología', 'Titular'),
(6,'Dra. Elena Torres', 'Oftalmología', 'Residente'),
(7,'Dr. José Ruiz', 'Ginecología', 'Titular'),
(8,'Dra. Laura Morales', 'Endocrinología', 'Titular'),
(9,'Dr. Pedro Rodríguez', 'Psiquiatría', 'Residente'),
(10,'Dra. Claudia Fernández', 'Oncología', 'Titular'),
(11,'Dr. Fernando Díaz', 'Nefrología', 'Titular'),
(12,'Dra. Andrea Ramírez', 'Reumatología', 'Residente'),
(13,'Dr. Javier Herrera', 'Cirugía General', 'Titular'),
(14,'Dra. Patricia Ortega', 'Otorrinolaringología', 'Titular'),
(15,'Dr. Sergio Castro', 'Gastroenterología', 'Residente'),
(16,'Dra. Rosa García', 'Infectología', 'Titular'),
(17,'Dr. Alberto Vázquez', 'Neumología', 'Residente'),
(18,'Dra. Marta Jiménez', 'Urología', 'Titular'),
(19,'Dr. Manuel Álvarez', 'Hematología', 'Residente'),
(20,'Dra. Silvia Muñoz', 'Radiología', 'Titular');
SHOW INDEX FROM Atenciones;
SHOW INDEX FROM historial_medicos;

ALTER TABLE historial_medicos
ADD CONSTRAINT FK_medico
FOREIGN KEY (medico_id) REFERENCES medicos (idMedicos);
ALTER TABLE atenciones
ADD CONSTRAINT FK_medicos
FOREIGN KEY (medico_id) REFERENCES medicos (idMedicos);
INSERT INTO historial_medicos  VALUES
(1,'Caries Dental', '2024-01-10', 'Sí', 'Empaste dental', 1),
(2,'Gingivitis', '2024-02-15', 'No', 'Limpieza dental', 2),
(3,'Absceso Dental', '2024-03-20', 'Sí', 'Drenaje y antibióticos', 1),
(4,'Fractura de Diente', '2024-04-05', 'Sí', 'Rehabilitación dental', 3),
(5,'Enfermedad Periodontal', '2024-05-12', 'No', 'Tratamiento periodontal', 2),
(6,'Sensibilidad Dental', '2024-06-30', 'No', 'Sellado de fisuras', 1),
(7,'Maloclusión', '2024-07-22', 'No', 'Referido a ortodoncista', 3),
(8,'Clavación de Diente', '2024-08-17', 'Sí', 'Extracción dental', 2),
(9,'Hiperplasia Gingival', '2024-09-10', 'No', 'Cirugía gingival', 1),
(10,'Bruxismo', '2024-10-01', 'No', 'Férula de descarga', 3);


