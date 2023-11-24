from faker import Faker
import mysql.connector

# constants to control the size of the dataset
NO_OF_SUPPLIERS = 500
NO_OF_PRODUCTS = 2000
NO_OF_WAREHOUSES = 500
NO_OF_EMPLOYEES = 5000
NO_OF_RETAILERS = 12000
NO_OF_ORDERS = 30000
NO_OF_CERTIFICATIONS = 500
NO_OF_SUPPLIER_PRODUCTS = 5000
NO_OF_HAS_CERTIFICATIONS = 5000
NO_OF_STORED_AT = 5000
NO_OF_EMPLOYEE_PHONES = NO_OF_EMPLOYEES * 2

# Test with smaller dataset
# NO_OF_SUPPLIERS = NO_OF_SUPPLIERS // 100
# NO_OF_PRODUCTS = NO_OF_PRODUCTS // 100
# NO_OF_WAREHOUSES = NO_OF_WAREHOUSES // 100
# NO_OF_EMPLOYEES = NO_OF_EMPLOYEES // 100
# NO_OF_RETAILERS = NO_OF_RETAILERS // 100
# NO_OF_ORDERS = NO_OF_ORDERS // 100
# NO_OF_CERTIFICATIONS = NO_OF_CERTIFICATIONS // 100
# NO_OF_SUPPLIER_PRODUCTS = NO_OF_SUPPLIER_PRODUCTS // 100
# NO_OF_HAS_CERTIFICATIONS = NO_OF_HAS_CERTIFICATIONS // 100
# NO_OF_STORED_AT = NO_OF_STORED_AT // 100
# NO_OF_EMPLOYEE_PHONES = NO_OF_EMPLOYEE_PHONES // 100

# Database Schema
# SupplierSynergy
#  Supplier (supplier_id, name, address, contact_name, contact_email, contact_phone, rating) PK: supplier_id FK: None
#  Product (product_id, name, description, unit_price) PK: product_id FK: None
#  Supplier_Product (supplier_id, product_id) PK: (supplier_id, product_id) FK: supplier_id, product_id
#  Warehouse (warehouse_id, address, capacity) PK: warehouse_id FK: None
#  Employee (employee_id, first_name, last_name, email, salary, warehouse_id) PK: employee_id FK: warehouse_id
#  Retailer (retailer_id, name, phone, address, email) PK: retailer_id FK: None
#  Certification (certification_id, name, authorized_by) PK: certification_id FK: None
#  Orders (order_id, status, oder_time, quantity, retailer_id, product_id) PK: order_id FK: retailer_id, product_id
#  Has_Certification (certification_id, supplier_id, expires) PK: (supplier_id, certification_id) FK: supplier_id, certification_id
#  Stored_at (product_id, warehouse_id, quantity) PK: (product_id, warehouse_id) FK: product_id, warehouse_id
#  Employee_phone (employee_id, phone) PK: (phone, employee_id) FK: employee_id


# Connect to the database
mydb = mysql.connector.connect(
  host="localhost",
  user="root",
  password="",
  database="SupplierSynergy"
)

# Create a cursor object
mycursor = mydb.cursor()

# Create a Faker object
fake = Faker()

# Generate a random phone number
def gen_phone_no():
  prefixes = ['018', '015', '017', '019']
  return fake.random_element(elements=prefixes) + str(fake.random_int(min=10000000, max=99999999))

# Clear a table
def clear_table(name):
  mycursor.execute("DELETE FROM " + name)
  mydb.commit()

# Clear all tables
def clear_tables():
  clear_table("Orders")
  clear_table("Supplier_Product")
  clear_table("Employee_phone")
  clear_table("Stored_at")
  clear_table("Has_Certification")
  clear_table("Supplier")
  clear_table("Product")
  clear_table("Retailer")
  clear_table("Employee")
  clear_table("Warehouse")
  clear_table("Certification")
  mydb.commit()

# store primary keys for later use
supplier_ids = []
product_ids = []
warehouse_ids = []
employee_ids = []
retailer_ids = []
order_ids = []
certification_ids = []


# Generate random data for the Supplier table
def fill_supplier_table():
  for i in range(NO_OF_SUPPLIERS):
    name = fake.company()
    address = fake.address()
    contact_name = fake.name()
    contact_email = fake.email()
    contact_phone = gen_phone_no()
    rating = fake.pyfloat(left_digits=1, right_digits=2, min_value=3, max_value=5)
    sql = "INSERT INTO Supplier (supplier_id, name, address, contact_name, contact_email, contact_phone, rating) VALUES (%s, %s, %s, %s, %s, %s, %s)"
    val = (i+1, name, address, contact_name, contact_email, contact_phone, rating)
    mycursor.execute(sql, val)
    supplier_ids.append(mycursor.lastrowid)
  mydb.commit()

# Generate random data for the Product table
def fill_product_table():
  for i in range(NO_OF_PRODUCTS):
    name = fake.word()
    description = fake.text()
    unit_price = fake.pyint()
    sql = "INSERT INTO Product (product_id, name, description, unit_price) VALUES (%s, %s, %s, %s)"
    val = (i+1, name, description, unit_price)
    mycursor.execute(sql, val)
    product_ids.append(mycursor.lastrowid)
  mydb.commit()
    

# Generate random data for the Supplier_Product table
def fill_supplier_product_table():
  existing_pairs = set()
  while len(existing_pairs) < NO_OF_SUPPLIER_PRODUCTS:
    supplier_id = fake.random_element(elements=supplier_ids)
    product_id = fake.random_element(elements=product_ids)
    if (supplier_id, product_id) not in existing_pairs:
      existing_pairs.add((supplier_id, product_id))
      sql = "INSERT INTO Supplier_Product (supplier_id, product_id) VALUES (%s, %s)"
      val = (supplier_id, product_id)
      mycursor.execute(sql, val)
  mydb.commit()


# Generate random data for the Warehouse table
def fill_warehouse_table():
  for i in range(NO_OF_WAREHOUSES):
    address = fake.address()
    capacity = fake.random_int(min=10, max=1000)
    sql = "INSERT INTO Warehouse (warehouse_id, address, capacity) VALUES (%s, %s, %s)"
    val = (i+1, address, capacity)
    mycursor.execute(sql, val)
    warehouse_ids.append(mycursor.lastrowid)
  mydb.commit()

# Generate random data for the Employee table
def fill_employee_table():
  for i in range(NO_OF_EMPLOYEES):
    first_name = fake.first_name()
    last_name = fake.last_name()
    email = fake.email()
    salary = fake.random_int(min=20000, max=100000)
    warehouse_id = fake.random_element(elements=warehouse_ids)
    sql = "INSERT INTO Employee (employee_id, first_name, last_name, email, salary, warehouse_id) VALUES (%s, %s, %s, %s, %s, %s)"
    val = (i+1, first_name, last_name, email, salary, warehouse_id)
    mycursor.execute(sql, val)
    employee_ids.append(mycursor.lastrowid)
  mydb.commit()

# Generate random data for the Retailer table
def fill_retailer_table():
  for i in range(NO_OF_RETAILERS):
    name = fake.company()
    phone = gen_phone_no()
    address = fake.address()
    email = fake.email()
    sql = "INSERT INTO Retailer (retailer_id, name, phone, address, email) VALUES (%s, %s, %s, %s, %s)"
    val = (i+1, name, phone, address, email)
    mycursor.execute(sql, val)
    retailer_ids.append(mycursor.lastrowid)
  mydb.commit()

# Generate random data for the Certification table
def fill_certification_table():
  for i in range(NO_OF_CERTIFICATIONS):
    name = fake.word().title() + " Certification"
    authorized_by = fake.company()
    sql = "INSERT INTO Certification (certification_id, name, authorized_by) VALUES (%s, %s, %s)"
    val = (i+1, name, authorized_by)
    mycursor.execute(sql, val)
    certification_ids.append(mycursor.lastrowid)
  mydb.commit()

# Generate random data for the Orders table
def fill_orders_table():
  status_list = ['CONFIRMED', 'PAID', 'PENDING', 'SHIPPED', 'DELIVERED']
  for i in range(NO_OF_ORDERS):
    status = fake.random_element(elements=status_list)
    order_time = fake.date()
    quantity = fake.random_int(min=1, max=1000)
    retailer_id = fake.random_element(elements=retailer_ids)
    product_id = fake.random_element(elements=product_ids)
    sql = "INSERT INTO Orders (order_id, status, oder_time, quantity, retailer_id, product_id) VALUES (%s, %s, %s, %s, %s, %s)"
    val = (i+1, status, order_time, quantity, retailer_id, product_id)
    mycursor.execute(sql, val)
    order_ids.append(mycursor.lastrowid)
  mydb.commit()

# Generate random data for the Has_Certification table
def fill_has_certification_table():
  existing_pairs = set()
  while len(existing_pairs) < NO_OF_HAS_CERTIFICATIONS:
    certification_id = fake.random_element(elements=certification_ids)
    supplier_id = fake.random_element(elements=supplier_ids)
    expires = fake.date()
    if (certification_id, supplier_id) not in existing_pairs:
      existing_pairs.add((certification_id, supplier_id))
      sql = "INSERT INTO Has_Certification (certification_id, supplier_id, expires) VALUES (%s, %s, %s)"
      val = (certification_id, supplier_id, expires)
      mycursor.execute(sql, val)
  mydb.commit()

# Generate random data for the Stored_at table
def fill_stored_at_table():
  existing_pairs = set()
  while len(existing_pairs) < NO_OF_STORED_AT:
    product_id = fake.random_element(elements=product_ids)
    warehouse_id = fake.random_element(elements=warehouse_ids)
    quantity = fake.random_int(min=1, max=1000)
    if (product_id, warehouse_id) not in existing_pairs:
      existing_pairs.add((product_id, warehouse_id))
      sql = "INSERT INTO Stored_at (product_id, warehouse_id, quantity) VALUES (%s, %s, %s)"
      val = (product_id, warehouse_id, quantity)
      mycursor.execute(sql, val)
  mydb.commit()

# Generate random data for the Employee_phone table
def fill_employee_phone_table():
  existing_pairs = set()
  while len(existing_pairs) < NO_OF_EMPLOYEE_PHONES:
    employee_id = fake.random_element(elements=employee_ids)
    phone = gen_phone_no()
    if (employee_id, phone) not in existing_pairs:
      existing_pairs.add((employee_id, phone))
      sql = "INSERT INTO Employee_phone (employee_id, phone) VALUES (%s, %s)"
      val = (employee_id, phone)
      mycursor.execute(sql, val)
  mydb.commit()


def main():
  clear_tables()

  fill_supplier_table()
  fill_product_table()
  fill_supplier_product_table()
  fill_warehouse_table()
  fill_employee_table()
  fill_retailer_table()
  fill_certification_table()
  fill_orders_table()
  fill_has_certification_table()
  fill_stored_at_table()
  fill_employee_phone_table()

  mydb.commit()
  mydb.close()


if __name__ == "__main__":
  main()
