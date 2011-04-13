def build_file(fileName)
  firstNames = ["Jacob", "Ethan", "Michael", "Alexander", "William", "Joshua", "Daniel", "Jayden", "Noah", "Anthony", "Isabella", "Emma", "Olivia", "Sophia", "Ava", "Emily", "Madison", "Abigail", "Chloe", "Mia"]
  lastNames = ["Smith", "Jones", "Thompson", "Williams", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor", "Anderson", "Thomas", "Jackson", "White", "Harris"]
  streets = ["Second", "Third", "Fourth", "Park", "Fifth", "Main", "Sixth", "Oak", "Seventh", "Pine", "Maple"]
  cities = ["Franklin", "Clinton", "Springfield", "Greenville", "Salen", "Fairview", "Madison"]
  states = ["AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "DC", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"]

    output = File.open(fileName, 'w')
    (1..100).each do |i|
      firstName = getRandomElement(firstNames)
      lastName = getRandomElement(lastNames)

      values = [firstName, lastName, rand(9999).to_s + " " + getRandomElement(streets), getRandomElement(cities), getRandomElement(states), ("%05d" % rand(99999))]

      output.puts values.join(",")
    end
end

def getRandomElement(array)
  array[rand(array.length)]
end

build_file(ARGV[0])
