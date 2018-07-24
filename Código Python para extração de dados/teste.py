import jsonlines


arq = open('The_Elder_Scrolls_V.txt', 'w+')

with jsonlines.open("The_Elder_Scrolls_V.jsonlines") as reader:
    for obj in reader.iter(type=dict, skip_invalid = True):
        if obj['rating'] == 'Not Recommended':
            string_aux = obj['review'] + ']'
            arq.write(string_aux)

arq.close()
        

