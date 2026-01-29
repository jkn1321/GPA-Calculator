import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class GPACalculatorGUI extends JFrame {

    private JTextField nameField;
    private JComboBox<String> gradeCombo, creditCombo;
    private JTable resultTable;
    private DefaultTableModel tableModel;
    private JLabel gpaLabel, totalsLabel;

    private double totalPoints = 0;
    private int totalCredits = 0;

    // Color scheme
    private final Color PRIMARY_COLOR = new Color(52, 152, 219);
    private final Color SECONDARY_COLOR = new Color(46, 204, 113);
    private final Color DANGER_COLOR = new Color(231, 76, 60);
    private final Color BACKGROUND_COLOR = new Color(236, 240, 241);
    private final Color PANEL_COLOR = Color.WHITE;
    private final Color TEXT_COLOR = new Color(44, 62, 80);

    public GPACalculatorGUI() {

        setTitle("GPA Calculator");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(BACKGROUND_COLOR);

        setLayout(new BorderLayout(15, 15));

        // Title Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(PRIMARY_COLOR);
        titlePanel.setBorder(new EmptyBorder(20, 10, 20, 10));
        JLabel titleLabel = new JLabel("GPA Calculator");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        // Input Panel
        JPanel mainInputPanel = new JPanel(new BorderLayout());
        mainInputPanel.setBackground(BACKGROUND_COLOR);
        mainInputPanel.setBorder(new EmptyBorder(10, 50, 10, 50));

        // Input section heading
        JLabel inputHeading = new JLabel("GPA Calculator", JLabel.CENTER);
        inputHeading.setFont(new Font("Arial", Font.BOLD, 20));
        inputHeading.setForeground(TEXT_COLOR);
        inputHeading.setBorder(new EmptyBorder(5, 0, 10, 0));

        // Developer name Section
        JLabel developerNameLabel = new JLabel("Developed by Januli Nanayakkara", JLabel.CENTER);
        developerNameLabel.setFont(new Font("Arial", Font.BOLD, 15));
        developerNameLabel.setForeground(TEXT_COLOR);
        developerNameLabel.setBorder(new EmptyBorder(0, 0, 10, 0));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBackground(PANEL_COLOR);
        inputPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(189, 195, 199), 1),
                new EmptyBorder(25, 30, 25, 30)));

        // Add heading and developer name to the input container
        JPanel inputContainer = new JPanel(new BorderLayout());
        inputContainer.setBackground(BACKGROUND_COLOR);
        inputContainer.add(inputHeading, BorderLayout.NORTH);
        inputContainer.add(developerNameLabel, BorderLayout.CENTER);
        inputContainer.add(inputPanel, BorderLayout.SOUTH);

        // Subject Name
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        namePanel.setBackground(PANEL_COLOR);
        JLabel nameLabel = new JLabel("Subject Name:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        nameLabel.setForeground(TEXT_COLOR);
        nameLabel.setPreferredSize(new Dimension(120, 25));
        namePanel.add(nameLabel);
        nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.PLAIN, 14));
        nameField.setPreferredSize(new Dimension(550, 35));
        nameField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(189, 195, 199), 1),
                new EmptyBorder(5, 10, 5, 10)));
        namePanel.add(nameField);
        inputPanel.add(namePanel);

        // Grade
        JPanel gradePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        gradePanel.setBackground(PANEL_COLOR);
        JLabel gradeLabel = new JLabel("Grade:");
        gradeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gradeLabel.setForeground(TEXT_COLOR);
        gradeLabel.setPreferredSize(new Dimension(120, 25));
        gradePanel.add(gradeLabel);
        String[] grades = { "A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "E", "F", "MC",
                "Non Credit(NC)" };
        gradeCombo = new JComboBox<>(grades);
        gradeCombo.setFont(new Font("Arial", Font.PLAIN, 14));
        gradeCombo.setPreferredSize(new Dimension(550, 35));
        gradePanel.add(gradeCombo);
        inputPanel.add(gradePanel);

        // Credit
        JPanel creditPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        creditPanel.setBackground(PANEL_COLOR);
        JLabel creditLabel = new JLabel("Credit:");
        creditLabel.setFont(new Font("Arial", Font.BOLD, 14));
        creditLabel.setForeground(TEXT_COLOR);
        creditLabel.setPreferredSize(new Dimension(120, 25));
        creditPanel.add(creditLabel);
        String[] credits = { "1", "2", "3", "4" };
        creditCombo = new JComboBox<>(credits);
        creditCombo.setFont(new Font("Arial", Font.PLAIN, 14));
        creditCombo.setPreferredSize(new Dimension(550, 35));
        creditPanel.add(creditCombo);
        inputPanel.add(creditPanel);

        // Add listener to grade combo to change credit options
        gradeCombo.addActionListener(e -> {
            String selectedGrade = (String) gradeCombo.getSelectedItem();
            creditCombo.removeAllItems();
            if ("Non Credit(NC)".equals(selectedGrade)) {
                creditCombo.addItem("0");
                creditCombo.setEnabled(false);
            } else {
                creditCombo.setEnabled(true);
                creditCombo.addItem("1");
                creditCombo.addItem("2");
                creditCombo.addItem("3");
                creditCombo.addItem("4");
            }
        });
        inputPanel.add(creditPanel);

        mainInputPanel.add(inputContainer, BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        buttonPanel.setBackground(BACKGROUND_COLOR);

        JButton addButton = createStyledButton("Add Subject", SECONDARY_COLOR);
        JButton deleteButton = createStyledButton("Delete Selected", DANGER_COLOR);

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(BACKGROUND_COLOR);
        topPanel.add(mainInputPanel, BorderLayout.CENTER);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(topPanel, BorderLayout.NORTH);

        // Center Panel - Table
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBackground(BACKGROUND_COLOR);
        tablePanel.setBorder(new EmptyBorder(0, 20, 10, 20));

        String[] columnNames = { "Subject Name", "Grade", "GPV", "Credit", "Total", "Status" };
        tableModel = new DefaultTableModel(columnNames, 0);
        resultTable = new JTable(tableModel);
        resultTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        resultTable.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
        resultTable.setRowHeight(30);
        resultTable.setGridColor(new Color(189, 195, 199));
        resultTable.setSelectionBackground(new Color(174, 214, 241));
        resultTable.setSelectionForeground(TEXT_COLOR);

        // Header styling
        resultTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        resultTable.getTableHeader().setBackground(new Color(52, 73, 94));
        resultTable.getTableHeader().setForeground(Color.WHITE);
        resultTable.getTableHeader().setBorder(BorderFactory.createLineBorder(new Color(52, 73, 94)));

        // Custom cell renderer for center alignment and row coloring
        DefaultTableCellRenderer customRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Get status from the last column (index 5)
                String status = (String) table.getModel().getValueAt(row, 5);

                if (!isSelected) {
                    if (status != null && (status.startsWith("Repeat") || status.startsWith("MC"))) {
                        c.setBackground(new Color(255, 243, 176));
                    } else {
                        c.setBackground(Color.WHITE);
                    }
                }

                // Center align for all columns except first (Subject Name)
                if (column > 0) {
                    setHorizontalAlignment(JLabel.CENTER);
                } else {
                    setHorizontalAlignment(JLabel.LEFT);
                }

                return c;
            }
        };

        // Apply custom renderer to all columns
        for (int i = 0; i < resultTable.getColumnCount(); i++) {
            resultTable.getColumnModel().getColumn(i).setCellRenderer(customRenderer);
        }

        JScrollPane scrollPane = new JScrollPane(resultTable);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199), 1));
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        add(tablePanel, BorderLayout.CENTER);

        // Bottom Panel with totals and GPA
        JPanel bottomPanel = new JPanel(new GridLayout(2, 1, 0, 10));
        bottomPanel.setBackground(PANEL_COLOR);
        bottomPanel.setBorder(BorderFactory.createCompoundBorder(
                new EmptyBorder(10, 20, 20, 20),
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(189, 195, 199), 1),
                        new EmptyBorder(15, 20, 15, 20))));

        totalsLabel = new JLabel("Total Points: 0.00 | Total Credits: 0", JLabel.CENTER);
        totalsLabel.setFont(new Font("Arial", Font.BOLD, 16));
        totalsLabel.setForeground(TEXT_COLOR);

        gpaLabel = new JLabel("GPA: 0.00", JLabel.CENTER);
        gpaLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gpaLabel.setForeground(PRIMARY_COLOR);

        bottomPanel.add(totalsLabel);
        bottomPanel.add(gpaLabel);
        add(bottomPanel, BorderLayout.SOUTH);

        // Button Actions
        addButton.addActionListener(e -> addSubject());
        deleteButton.addActionListener(e -> deleteSelected());
    }

    private JButton createStyledButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(bgColor);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(150, 40));

        // Hover effect
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(bgColor.darker());
            }

            public void mouseExited(MouseEvent e) {
                button.setBackground(bgColor);
            }
        });

        return button;
    }

    private void addSubject() {

        // Validate subject name
        String subjectName = nameField.getText().trim();
        if (subjectName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Subject name cannot be empty!", "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            nameField.requestFocus();
            return;
        }

        // Check for duplicate subject name
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String existingName = (String) tableModel.getValueAt(i, 0);
            if (existingName.equalsIgnoreCase(subjectName)) {
                JOptionPane.showMessageDialog(this,
                        "Subject '" + subjectName + "' already exists! Please use a different name.",
                        "Duplicate Subject",
                        JOptionPane.WARNING_MESSAGE);
                nameField.requestFocus();
                nameField.selectAll();
                return;
            }
        }

        // Get values from combo boxes
        String grade = (String) gradeCombo.getSelectedItem();
        int credit = Integer.parseInt((String) creditCombo.getSelectedItem());

        double gradePoint;
        String status;

        switch (grade) {
            case "A+":
                gradePoint = 4.00;
                status = "Pass 😊";
                break;
            case "A":
                gradePoint = 4.00;
                status = "Pass 😊";
                break;
            case "A-":
                gradePoint = 3.70;
                status = "Pass 😊";
                break;
            case "B+":
                gradePoint = 3.30;
                status = "Pass 😊";
                break;
            case "B":
                gradePoint = 3.00;
                status = "Pass 😊";
                break;
            case "B-":
                gradePoint = 2.70;
                status = "Pass 😊";
                break;
            case "C+":
                gradePoint = 2.30;
                status = "Pass 😊";
                break;
            case "C":
                gradePoint = 2.00;
                status = "Pass 😊";
                break;
            case "C-":
                gradePoint = 1.70;
                status = "Repeat 😢";
                break;
            case "D+":
                gradePoint = 1.30;
                status = "Repeat 😢";
                break;
            case "D":
                gradePoint = 1.00;
                status = "Repeat 😢";
                break;
            case "E":
                gradePoint = 0.00;
                status = "Repeat 😢";
                break;
            case "F":
                gradePoint = 0.00;
                status = "Repeat 😢";
                break;
            case "MC":
                gradePoint = 0.00;
                status = "MC 🤒";
                break;
            case "Non Credit(NC)":
                gradePoint = 0.00;
                status = "Non Credit";
                break;
            default:
                gradePoint = 0.00;
                status = "Unknown";
                break;
        }

        totalPoints += gradePoint * credit;
        totalCredits += credit;

        // Calculate total for this subject
        double subjectTotal = gradePoint * credit;

        // Add row to table
        Object[] rowData = { subjectName, grade, gradePoint, credit, String.format("%.2f", subjectTotal), status };
        tableModel.addRow(rowData);

        // Update totals and GPA
        updateTotalsAndGPA();

        nameField.setText("");
        gradeCombo.setSelectedIndex(0);
        creditCombo.setSelectedIndex(0);
    }

    private void deleteSelected() {
        int selectedRow = resultTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete!", "No Selection",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Recalculate totals by subtracting the deleted row's values
        double gpv = Double.parseDouble(tableModel.getValueAt(selectedRow, 2).toString());
        int credit = Integer.parseInt(tableModel.getValueAt(selectedRow, 3).toString());

        totalPoints -= gpv * credit;
        totalCredits -= credit;

        // Remove row from table
        tableModel.removeRow(selectedRow);

        // Update totals and GPA
        updateTotalsAndGPA();
    }

    private void updateTotalsAndGPA() {
        totalsLabel
                .setText("Total Points: " + String.format("%.2f", totalPoints) + " | Total Credits: " + totalCredits);

        if (totalCredits > 0) {
            double gpa = totalPoints / totalCredits;
            gpaLabel.setText("GPA: " + String.format("%.2f", gpa));
        } else {
            gpaLabel.setText("GPA: ");
        }
    }

    public static void main(String[] args) {
        new GPACalculatorGUI().setVisible(true);
    }
}
