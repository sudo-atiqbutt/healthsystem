-- Insert patients
INSERT INTO patient (name, age) VALUES ('John Doe', 30);
INSERT INTO patient (name, age) VALUES ('Jane Smith', 40);

-- Insert medicines
INSERT INTO medicine (name, description) VALUES ('Aspirin', 'Pain reliever');
INSERT INTO medicine (name, description) VALUES ('Paracetamol', 'Fever reducer');

-- Indexes
CREATE INDEX idx_patient_name ON patient (name);
CREATE INDEX idx_medicine_name ON medicine (name);